package constraints;

public interface DoubleConstraint extends OptionConstraint<Double> {

    @Override
    boolean isFulfilled(Double argument);
}
