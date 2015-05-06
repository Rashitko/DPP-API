package arguments;


import com.sun.istack.internal.Nullable;

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
     * @param parser Parser which will be used for parsing this argument
     */
    public Argument(Parser<T> parser) {
        this.constraint = null;
        this.parser = parser;
    }

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
    public Parser<T> getParser() {
        return parser;
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
    void setValue(T value) {
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
        return null
    }

    @Nullable
    private String getParsingError() {
        if (value == null) {
            return parser.getParseErrorMessage();
        }
        return null;

    }

   @Nullable
   private String getConstraintError() {
       if (value != null) {
           if (!constraint.isFulfilled(value)) {
               return Optional.of(constraint.getErrorMessage(value));
           }
        }
       return null;
   }
}
