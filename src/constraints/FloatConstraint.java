package constraints;

/**
 * Basic interface for all float constraints
 */
public interface FloatConstraint extends ArgumentConstraint<Float> {
    @Override
    public boolean isFulfilled(Float argument);
}
