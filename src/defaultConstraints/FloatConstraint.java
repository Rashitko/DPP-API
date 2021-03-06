package defaultConstraints;

import arguments.Constraint;

/**
 * Basic interface for all float constraints
 */
public interface FloatConstraint extends Constraint<Float> {
    @Override
    boolean isFulfilled(Float argument);
}
