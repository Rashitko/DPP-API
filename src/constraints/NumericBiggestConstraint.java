package constraints;

import arguments.ArgumentConstraint;

public class NumericBiggestConstraint<T extends Number & Comparable<T>> implements ArgumentConstraint<T> {

    private final T max;

    public NumericBiggestConstraint(T max) {
        this.max = max;
    }

    @Override
    public boolean isFulfilled(T argument) {
        return max.compareTo(argument) >= 0;
    }

}