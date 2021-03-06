package defaultConstraints;

import arguments.Constraint;

/**
 * This class represent a constraint which is fulfilled when the argument value is lower or equal than
 * the specified upper bound
 *
 * @param <T> type for which the upper bound is defined
 */
public class UpperBoundConstraint<T extends Comparable<T>> implements Constraint<T> {

    private final T max;

    /**
     * This constructor sets the upper bound
     *
     * @param max upper bound
     */
    public UpperBoundConstraint(T max) {
        this.max = max;
    }

    @Override
    public boolean isFulfilled(T argument) {
        return max.compareTo(argument) >= 0;
    }

    @Override
    public String getErrorMessage(T argument) {
        //TODO:
        return null;
    }

}