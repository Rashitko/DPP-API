package constraints;

public class LowerBoundConstraint<T extends Comparable<T>> implements ArgumentConstraint<T> {

    private final T min;

    public LowerBoundConstraint(T min) {
        this.min = min;
    }

    @Override
    public boolean isFulfilled(T argument) {
        return argument.compareTo(min) >= 0;
    }

}