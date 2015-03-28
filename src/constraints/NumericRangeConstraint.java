package constraints;

import arguments.ArgumentConstraint;

public class NumericRangeConstraint<T extends Number & Comparable<T>> implements ArgumentConstraint<T> {

    private final T min;
    private final T max;

    public NumericRangeConstraint(T min, T max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isFulfilled(T argument) {
        final boolean isBiggerThanMin = argument.compareTo(min) >= 0;
        final boolean isLessThanMax = max.compareTo(argument) >= 0;
        return isBiggerThanMin && isLessThanMax;
    }

}
