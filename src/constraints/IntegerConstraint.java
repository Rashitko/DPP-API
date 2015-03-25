package constraints;

public interface IntegerConstraint extends ArgumentConstraint<Integer> {

    @Override
    boolean isFulfilled(Integer argument);
}
