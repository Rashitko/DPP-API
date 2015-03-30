package constraints;

public class UpperBoundConstraint<T extends Comparable<T>> implements ArgumentConstraint<T> {

    private final T max;

    public UpperBoundConstraint(T max) {
        this.max = max;
    }

    @Override
    public boolean isFulfilled(T argument) {
        return max.compareTo(argument) >= 0;
    }

}