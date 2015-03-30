package constraints;

public class RangeConstraint<T extends Comparable<T>> implements ArgumentConstraint<T> {

    private final T min;
    private final T max;

    public RangeConstraint(T min, T max) {
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
