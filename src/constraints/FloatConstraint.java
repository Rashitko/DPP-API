package constraints;

import arguments.ArgumentConstraint;

public interface FloatConstraint extends ArgumentConstraint<Float> {
    @Override
    public boolean isFulfilled(Float argument);
}
