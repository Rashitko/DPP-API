package constraints;

public interface IntegerConstraint extends OptionConstraint<Integer>{

    @Override
    boolean isFulfilled(Integer argument);
}
