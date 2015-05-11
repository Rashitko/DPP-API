package DPPParser.defaultConstrains;

/**
 * This class represent a constraint which is fulfilled when the string's length is higher than or at least
 * the same as the minimal bound
 */
public class StringMaxLengthConstraint implements StringConstraint {

    private final int max;

    /**
     * This constructor sets the maximal length
     *
     * @param max maximal length
     */
    public StringMaxLengthConstraint(int max) {
        this.max = max;
    }

    @Override
    public boolean isFulfilled(String argument) {
        return argument.length() <= max;
    }

    @Override
    public String getErrorMessage(String argument) {
        return "\"" + argument + "\" length is not lower than" + max;
    }
}
