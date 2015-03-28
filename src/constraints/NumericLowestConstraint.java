package constraints;

import arguments.ArgumentConstraint;

public class NumericLowestConstraint<T extends Number & Comparable<T>> implements ArgumentConstraint<T> {

    private final T min;

    public NumericLowestConstraint(T min) {
        this.min = min;
    }

    @Override
    public boolean isFulfilled(T argument) {
        return argument.compareTo(min) >= 0;
    }

}