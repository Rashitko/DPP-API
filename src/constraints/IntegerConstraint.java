package constraints;

/**
 * Basic interface for all integer constrains
 */
public interface IntegerConstraint extends ArgumentConstraint<Integer> {

    @Override
    boolean isFulfilled(Integer argument);
}
