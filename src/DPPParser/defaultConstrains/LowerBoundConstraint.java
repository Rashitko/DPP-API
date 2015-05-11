package DPPParser.defaultConstrains;

import DPPParser.arguments.Constraint;

/**
 * This class represent a constraint which is fulfilled when the argument value is higher or equal than
 * the specified lower bound
 *
 * @param <T> type for which the lower bound is defined
 */
public class LowerBoundConstraint<T extends Comparable<T>> implements Constraint<T> {

    private final T min;

    /**
     * This constructor sets the lower bound
     *
     * @param min lower bound
     */
    public LowerBoundConstraint(T min) {
        this.min = min;
    }

    @Override
    public boolean isFulfilled(T argument) {
        return argument.compareTo(min) >= 0;
    }

    @Override
    public String getErrorMessage(T argument) {
        //TODO:
        return null;
    }

}