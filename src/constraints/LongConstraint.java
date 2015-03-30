package constraints;

/**
 * Basic interface for all long constraints
 */
public interface LongConstraint extends ArgumentConstraint<Long> {

    @Override
    public boolean isFulfilled(Long argument);
}
