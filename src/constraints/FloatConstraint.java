package constraints;

import arguments.Constraint;

/**
 * Basic interface for all float constraints
 */
public interface FloatConstraint extends Constraint<Float> {
    @Override
    public boolean isFulfilled(Float argument);
}
