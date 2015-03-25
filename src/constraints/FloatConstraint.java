package constraints;

public interface FloatConstraint extends OptionConstraint<Float> {
    @Override
    public boolean isFulfilled(Float argument);
}
