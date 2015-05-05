package constraints;

/**
 * Basic interface for all double constraints
 */
public interface DoubleConstraint extends ArgumentConstraint<Double> {

    @Override
    boolean isFulfilled(Double argument);
}
