package constraints;

import arguments.ArgumentConstraint;

public interface LongConstraint extends ArgumentConstraint<Long> {

    @Override
    public boolean isFulfilled(Long argument);
}
