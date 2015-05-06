package constraints;

import arguments.Constraint;

/**
 * Basic interface for all integer constraints
 */
public interface IntegerConstraint extends Constraint<Integer> {

    @Override
    boolean isFulfilled(Integer argument);
}
