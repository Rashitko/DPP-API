package constraints;

/**
 * Basic interface for all integer constraints
 */
public interface IntegerConstraint extends ArgumentConstraint<Integer> {

    @Override
    boolean isFulfilled(Integer argument);
}
