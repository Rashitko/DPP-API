package constraints;

import arguments.ArgumentConstraint;

public interface DoubleConstraint extends ArgumentConstraint<Double> {

    @Override
    boolean isFulfilled(Double argument);
}
