package constraints;

/**
 * Basic interface for all double constrains
 */
public interface DoubleConstraint extends ArgumentConstraint<Double> {

    @Override
    boolean isFulfilled(Double argument);
}
