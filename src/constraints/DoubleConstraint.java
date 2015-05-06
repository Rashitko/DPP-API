package constraints;

import arguments.Constraint;

/**
 * Basic interface for all double constraints
 */
public interface DoubleConstraint extends Constraint<Double> {

    @Override
    boolean isFulfilled(Double argument);
}
