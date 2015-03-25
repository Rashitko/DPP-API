package constraints;

import arguments.ArgumentConstraint;

public interface IntegerConstraint extends ArgumentConstraint<Integer> {

    @Override
    boolean isFulfilled(Integer argument);
}
