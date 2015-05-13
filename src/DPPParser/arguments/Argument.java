package DPPParser.arguments;


import javax.annotation.Nullable;

/**
 * This class represents an argument of an option
 *
 * @param <T> Type of this argument
 */
public class Argument<T> {

    private final Constraint<T> constraint;
    private final ArgumentParser<T> argumentParser;
    private T value;

    /**
     * @param argumentParser Parser which will be used for parsing this argument
     */
    public Argument(ArgumentParser<T> argumentParser) {
        this.constraint = null;
        this.argumentParser = argumentParser;
    }

    /**
     * @param constraint Constraint which will be applied on this argument
     * @param argumentParser     Parser which will be used for parsing this argument
     */
    public Argument(Constraint<T> constraint, ArgumentParser<T> argumentParser) {
        this.constraint = constraint;
        this.argumentParser = argumentParser;
    }

    /**
     * Get the constraint for this argument
     *
     * @return the constraint for this argument, null if no constraint is set
     */
    public Constraint<T> getConstraint() {
        return constraint;
    }

    /**
     * Get the parser for this argument
     *
     * @return the parser for this argument
     */
    public ArgumentParser<T> getArgumentParser() {
        return argumentParser;
    }

    /**
     * Get the value of the argument
     *
     * @return value of the argument, null of the argument is not set
     */
    public T getValue() {
        return value;
    }

    /**
     * Set the value of the argument
     *
     * @param value value to be set
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Get the error message which occurred during the parsing phase or during the constraints checking phase
     *
     * @return the error message which occurred during the parsing phase or during the constraints checking phase,
     * returns null when no error occurred
     */
    @Nullable
    public String getErrorMessage() {
        if (getParsingError() != null) {
            return getParsingError();
        }
        if (getConstraintError() != null) {
            return getConstraintError();
        }
        return null;
    }

    /**
     * @return errors from {@link ArgumentParser}
     */
    @Nullable
    private String getParsingError() {
        if (value == null) {
            return argumentParser.getParseErrorMessage();
        }
        return null;

    }

    /**
     * @return errors from {@link Constraint}
     */
    @Nullable
    private String getConstraintError() {
        if (value != null) {
            if (!constraint.isFulfilled(value)) {
                return constraint.getErrorMessage(value);
            }
        }
        return null;
    }

    /**
     * @return true if value is set
     */
    public boolean hasValue() {
        return value != null;
    }

    /**
     * @return true, if constraint is set
     */
    public boolean hasConstraint() {
        return constraint != null;
    }
}
