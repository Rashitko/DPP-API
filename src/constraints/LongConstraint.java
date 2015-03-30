package constraints;

/**
 * Basic interface for all long constrains
 */
public interface LongConstraint extends ArgumentConstraint<Long> {

    @Override
    public boolean isFulfilled(Long argument);
}
