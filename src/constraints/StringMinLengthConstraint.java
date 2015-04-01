package constraints;

/**
 * This class represent a constraint which is fulfilled when the string's length is higher than or at least
 * the same as the minimal bound
 */
public class StringMinLengthConstraint implements StringConstraint {

    private final int min;

    /**
     * This constructor sets the minimal length
     *
     * @param min minimal length
     */
    public StringMinLengthConstraint(int min) {
        //TODO
        this.min = min;
    }

    @Override
    public boolean isFulfilled(String argument) {
        //TODO
        return false;
    }

    @Override
    public String getErrorMessage(String argument) {
        //TODO
        return null;
    }
}
