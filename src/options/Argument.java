package options;

import constraints.ArgumentConstraint;
import parsers.ArgumentParser;

import java.util.HashSet;
import java.util.Set;

/**
 * Class representing option's argument
 *
 * @param <T> Type used in the argument
 */
public class Argument<T> {

    private final Set<ArgumentConstraint<T>> constraints;
    private final ArgumentParser<T> parser;
    private T value;

    private Argument(Builder<T> builder) {
        constraints = builder.constraints;
        parser = builder.parser;
    }

    /**
     * Gets set of argument constrains for this argument
     * @return set of argument constrains for this argument
     */
    public Set<ArgumentConstraint<T>> getConstraints() {
        return constraints;
    }

    /**
     * Gets parser for this argument
     * @return parser for this argument
     */
    public ArgumentParser<T> getParser() {
        return parser;
    }

    /**
     * Gets value of the argument
     * @return value of the argument or null if the value is not set
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value of the argument
     *
     * @param value value to be set
     */
    void setValue(T value) {
        this.value = value;
    }

    /**
     * Checks whether this argument has option or not
     * @return true if this argument has value, otherwise false
     */
    public boolean hasValue() {
        //TODO:
        return true;
    }

    /**
     * Gets the set of error messages which occurred during parsing and possibly during constraints checking
     *
     * @return the set of error messages which occurred during parsing and possibly during constraints checking
     */
    public Set<String> getErrorMessages() {
        HashSet<String> result = new HashSet<String>();
        if (value == null) {
            result.addAll(getParsingErrors());
        } else {
            result.addAll(getConstraintErrors());
        }
        return result;
    }

    private Set<String> getParsingErrors() {
        HashSet<String> result = new HashSet<String>();
        result.add(parser.getParseErrorMessage());
        return result;
    }

    private Set<String> getConstraintErrors() {
        HashSet<String> result = new HashSet<String>();
        for (ArgumentConstraint<T> constraint : constraints) {
            if (!constraint.isFulfilled(getValue())) {
                result.add(constraint.getErrorMessage(getValue()));
            }
        }
        return result;
    }

    /**
     * This class is used to create arguments
     *
     * @param <T> Argument type
     */
    public static class Builder<T> {

        private final Set<ArgumentConstraint<T>> constraints;
        private final ArgumentParser<T> parser;

        /**
         * Argument's builder constructor
         * @param parser argument's parser
         */
        public Builder(ArgumentParser<T> parser) {
            this.parser = parser;
            constraints = new HashSet<ArgumentConstraint<T>>();
        }

        /**
         * Sets constraint for the argument
         * @param constraint constraint to be set
         * @return Builder object
         */
        public Builder<T> addConstraint(ArgumentConstraint<T> constraint) {
            this.constraints.add(constraint);
            return this;
        }

        /**
         * Creates argument object
         * @return created argument object
         */
        public Argument<T> build() {
            return new Argument<T>(this);
        }
    }

}
