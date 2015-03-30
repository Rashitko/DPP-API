package constraints;

public interface FloatConstraint extends ArgumentConstraint<Float> {
    @Override
    public boolean isFulfilled(Float argument);
}
