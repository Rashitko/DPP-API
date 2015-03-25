package constraints;

public class IntegerRangeConstraint implements IntegerConstraint {

    private final int min;
    private final int max;

    public IntegerRangeConstraint(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isFulfilled(Integer argument) {
        return argument >= min && argument <= max;
    }
}
