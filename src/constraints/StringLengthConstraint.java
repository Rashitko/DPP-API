package constraints;

public class StringLengthConstraint implements StringConstraint {

    private final int min;
    private final int max;

    public StringLengthConstraint(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isFulfilled(String argument) {
        boolean result = argument.length() >= min && argument.length() <= max;
        return result;
    }
}
