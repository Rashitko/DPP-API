package constraints;

/**
 * Basic interface for all argument constraints
 *
 * @param <E> Type of argument
 */
public interface ArgumentConstraint<E> {

    /**
     * Tests if the constraints is fulfilled
     *
     * @param argument argument on which the constraint is tested
     * @return true if constraint is fulfilled, false otherwise
     */
    public boolean isFulfilled(E argument);


    /**
     * Gets the error message for the situation when constraint is not fulfilled
     *
     * @param argument the argument on which the constraint is not fulfilled
     * @return the error message for the situation when constraint is not fulfilled
     */
    public String getErrorMessage(E argument);

}
