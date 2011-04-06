/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation.DataIdentification;

import Mathematics.*;

/**
 * Locates the interval from a set of values that contains the target value.
 * @author Rune Dahl Iversen
 */
public class IntervalFinderReal {
    /**
     * Computes the interval from the specified set of values that either
     * contain the target value or is closest to doing so.
     * @param value Target value.
     * @param data  Set of values.
     * @return      Interval.
     */
    public Interval<Double> getNeighbors(final double value,
            final Iterable<Double> data) {
        if (data == null)
            throw new NullPointerException("Data not properly specified.");
        double iBefore = Double.NEGATIVE_INFINITY;
        double iAfter = Double.POSITIVE_INFINITY;
        for (double i : data) {
            if (i <= value && iBefore < i)
                iBefore = i;
            if (value <= i && i < iAfter)
                iAfter = i;
        }
        if (Double.isInfinite(iBefore)) {
            iBefore = iAfter;
            iAfter = Double.POSITIVE_INFINITY;
            for (double i : data) {
                if (iBefore < i && i < iAfter)
                    iAfter = i;
            }
            if (Double.isInfinite(iAfter))
                iAfter = iBefore;
        }
        if (Double.isInfinite(iAfter)) {
            iAfter = iBefore;
            iBefore = Double.NEGATIVE_INFINITY;
            for (double i : data) {
                if (i < iAfter && iBefore < i)
                    iBefore = i;
            }
            if (Double.isInfinite(iBefore))
                iBefore = iAfter;
        }
        if (Double.isInfinite(iBefore) || Double.isInfinite(iAfter))
            throw new ArithmeticException("Dataset is empty.");
        Interval<Double> id = new IntervalReal(
                iBefore, Interval.EndType.Includes,
                iAfter, Interval.EndType.Includes);
        return id;
    }
}
