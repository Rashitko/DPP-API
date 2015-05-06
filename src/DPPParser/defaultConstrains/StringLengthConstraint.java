package DPPParser.defaultConstrains;

/**
 * This class represent a constraint which is fulfilled when the string's length is between the minimal
 * and maximal bound, including both boundary values
 */
public class StringLengthConstraint implements StringConstraint {

    private final int min;
    private final int max;

    /**
     * This constructor sets the minimal and maximal length
     *
     * @param min minimal length
     * @param max maximal length
     */
    public StringLengthConstraint(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isFulfilled(String argument) {
        return argument.length() >= min && argument.length() <= max;
    }

    @Override
    public String getErrorMessage(String argument) {
        //TODO:
        return null;
    }
}
