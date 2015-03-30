package constraints;

public interface DoubleConstraint extends ArgumentConstraint<Double> {

    @Override
    boolean isFulfilled(Double argument);
}
