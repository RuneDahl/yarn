/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

/**
 * Implementation of the <a href="http://en.wikipedia.org/wiki/Mersenne_twister">
 * Mersenne twister</a> pseudo {@see Generator random number generator}.<br>
 * <a href="http://www.math.sci.hiroshima-u.ac.jp/~m-mat/MT/emt.html">
 * Mersenne twister homepage</a>.<br>
 * --<br>
 * Copyright (c) 2006,2007 Mutsuo Saito, Makoto Matsumoto and Hiroshima<br>
 * University. All rights reserved.<br>
 * <br>
 * Redistribution and use in source and binary forms, with or without<br>
 * modification, are permitted provided that the following conditions are<br>
 * met:<br>
 * <br>
 *     * Redistributions of source code must retain the above copyright<br>
 *       notice, this list of conditions and the following disclaimer.<br>
 *     * Redistributions in binary form must reproduce the above<br>
 *       copyright notice, this list of conditions and the following<br>
 *       disclaimer in the documentation and/or other materials provided<br>
 *       with the distribution.<br>
 *     * Neither the name of the Hiroshima University nor the names of<br>
 *       its contributors may be used to endorse or promote products<br>
 *       derived from this software without specific prior written<br>
 *       permission.<br>
 * <br>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS<br>
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT<br>
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR<br>
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT<br>
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,<br>
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT<br>
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,<br>
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY<br>
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT<br>
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE<br>
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.<br>
 * --<br>
 * @author Rune Dahl Iversen
 */
public final class MersenneTwister
        implements Seed<Long, Long> {
    private final static int _n = 624;
    private final static int _m = 397;
    private final static int _upperMask = 0x80000000;
    private final static int _lowerMask = 0x7fffffff;
    private final static int[] _a = new int[] { 0x0 , 0x9908b0df };

    private final static int _seedFactor = 1812433253;
    private final static double _normalize = 4294967296L;

    /* Tempering parameters */
    private final static int _maskB = 0x9d2c5680;
    private final static int _maskC = 0xefc60000;

    /* State */
    private int[] _cache = null;
    private int _index = 0;

    public MersenneTwister(long seed) {
        this.setSeed(seed);
    }

    @Override
    public Long getSample() {
        int y;
        if (_n <= _index) {
            for (_index = 0; _index < _n - _m; _index++) {
                y = (_cache[_index] & _upperMask) | (_cache[_index + 1] & _lowerMask);
                _cache[_index] = _cache[_index + _m] ^ (y >>> 1) ^ _a[(int)(y & 0x1)];
            }
            for (; _index < _n - 1; _index++) {
                y = (_cache[_index] & _upperMask) | (_cache[_index + 1] & _lowerMask);
                _cache[_index] = _cache[_index + _m - _n] ^ (y >>> 1) ^ _a[(int)(y & 0x1)];
            }
            y = (_cache[_index] & _upperMask) | (_cache[0] & _lowerMask);
            _cache[_index] = _cache[_index + _m - _n] ^ (y >>> 1) ^ _a[(int)(y & 0x1)];
            _index = 0;
        }
        y = _cache[_index++];
        y ^= _ShiftU(y);
        y ^= _ShiftS(y);
        y ^= _ShiftT(y);
        y ^= _ShiftL(y);
        return (long)y;
    }

    @Override
    public Long[] getSample(final int count) {
        Long[] simulations = new Long[count];
        for (int i = 0; i < count; i++) {
            simulations[i] = this.getSample();
        }
        return simulations;
    }

    @Override
    public void setSeed(final Long seed) {
        //if (_cache == null) // Lazy (Safe?) initialization of the array.
        //    _cache = new int[_n];
        long s = seed;
        _cache[0] = (int)s; //Function.IntegerNumbers.BoundedLong(seed, "Seed", 0, 4294967296L);
        for (_index = 1; _index < _n; _index++) {
            _cache[_index] = _SeedShift(_cache[_index - 1]) + _index;
        }
        _index = 0;
    }

    private final int _ShiftU(int value) { return value >>> 11; }
    private final int _ShiftS(int value) { return (value << 7) & _maskB; }
    private final int _ShiftT(int value) { return (value << 15) & _maskC; }
    private final int _ShiftL(int value) { return value >>> 18; }
    private final int _SeedShift(int value) {
        return _seedFactor * (value ^ (value >>> 30));
    }
}