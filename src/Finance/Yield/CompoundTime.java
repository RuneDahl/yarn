/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Yield;

/**
 * Implementation of a <a href="http://en.wikipedia.org/wiki/Compounding_of_interest#Periodic_compounding">
 * discreetly compounding</a> {@see Convention yield convention} at some
 * specified {@see HasCompoundingFrequency frequency}.
 * @author Rune Dahl Iversen
 */
public class CompoundTime extends HasCompoundingFrequency<Double, Double> {
    /**
     * Creates an instance of a discreetly compounding yield convention using
     * the specified frequency.
     * @param frequency Compounding frequency.
     */
    public CompoundTime(final double frequency) {
        super(frequency);
    }
    
    @Override
    public double discountFactor(final Double start, final Double end, final double yield) {
        return Math.pow(1.0 + yield/this.getFrequency(), (start-end)*this.getFrequency());
    }
    
    @Override
    public String getName() {
        return "Compound(" + Double.toString(this.getFrequency()) + ")";
    }

    @Override
    public Double time(final double discountFactor, final double yield) {
        return -Math.log(discountFactor) / (this.getFrequency()*
                Math.log1p(yield/this.getFrequency()));
    }

    @Override
    public double yield(final double discountFactor,
            final Double start, final Double end) {
        return this.getFrequency() *
                (Math.pow(discountFactor, 1.0/((start-end)*this.getFrequency()))
                    - 1.0);
    }
}
