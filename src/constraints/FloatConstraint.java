package constraints;

/**
 * Basic interface for all float constrains
 */
public interface FloatConstraint extends ArgumentConstraint<Float> {
    @Override
    public boolean isFulfilled(Float argument);
}
