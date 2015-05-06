package arguments;


import java.util.Optional;

/**
 * This class represents an argument of an option
 *
 * @param <T> Type of this argument
 */
public class Argument<T> {

    private final Constraint<T> constraint;
    private final Parser<T> parser;
    private T value;

    /**
     * @param constraint Constraint which will be applied on this argument
     * @param parser     Parser which will be used for parsing this argument
     */
    public Argument(Constraint<T> constraint, Parser<T> parser) {
        this.constraint = constraint;
        this.parser = parser;
    }

    /**
     * Get the constraint for this argument
     *
     * @return the constraint for this argument
     */
    public Constraint<T> getConstraint() {
        return constraint;
    }

    /**
     * Get the parser for this argument
     *
     * @return the parser for this argument
     */
    public Parser<T> getParser() {
        return parser;
    }

    /**
     * Get the value of the argument
     *
     * @return value of the argument
     */
    public Optional<T> getValue() {
        if (value == null) {
            return Optional.empty();
        }
        return Optional.of(value);
    }

    /**
     * Set the value of the argument
     *
     * @param value value to be set
     */
    void setValue(T value) {
        this.value = value;
    }

    /**
     * Get the error message which occurred during the parsing phase or during the constraints checking phase
     *
     * @return the error message which occurred during the parsing phase or during the constraints checking phase
     */
    public Optional<String> getErrorMessage() {
        if (getParsingError().isPresent()) {
            return getParsingError();
        }
        if (getConstraintError().isPresent()) {
            return getConstraintError();
        }
        return Optional.empty();
    }

    private Optional<String> getParsingError() {
        if (!getValue().isPresent()) {
            return Optional.of(parser.getParseErrorMessage());
        }
        return Optional.empty();

    }

    private Optional<String> getConstraintError() {
        if (getValue().isPresent()) {
            if (!constraint.isFulfilled(getValue().get())) {
                return Optional.of(constraint.getErrorMessage(getValue().get()));
            }
        }
        return Optional.empty();
    }
}
