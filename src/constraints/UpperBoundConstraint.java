package constraints;

/**
 * This class represent a constraint which is fulfilled when the argument value is lower or equal than
 * the specified upper bound
 *
 * @param <T> type for which the upper bound is defined
 */
public class UpperBoundConstraint<T extends Comparable<T>> implements ArgumentConstraint<T> {

    private final T max;

    /**
     * This constructor sets the upper bound
     *
     * @param max upper bound
     */
    public UpperBoundConstraint(T max) {
        //TODO
        this.max = max;
    }

    @Override
    public boolean isFulfilled(T argument) {
        //TODO
        return false;
    }

    @Override
    public String getErrorMessage(T argument) {
        //TODO:
        return null;
    }

}