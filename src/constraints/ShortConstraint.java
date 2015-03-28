package constraints;

import arguments.ArgumentConstraint;

public interface ShortConstraint extends ArgumentConstraint<Short> {

    @Override
    public boolean isFulfilled(Short argument);
}
