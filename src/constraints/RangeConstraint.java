package constraints;


/**
 * This class represent a constraint which is fulfilled when the argument value is between the lower and upper bound,
 * including both boundary values
 *
 * @param <T> type for which the lower bound and upper bound is defined
 */
public class RangeConstraint<T extends Comparable<T>> implements ArgumentConstraint<T> {

    private final T min;
    private final T max;

    /**
     * This constructor sets the lower and upper bound
     * @param min lower bound
     * @param max upper bound
     */
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

    @Override
    public String getErrorMessage(T argument) {
        //TODO:
        return null;
    }

}
