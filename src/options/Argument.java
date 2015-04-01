package options;

import com.sun.istack.internal.Nullable;
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
        //TODO
        constraints = builder.constraints;
        parser = builder.parser;
    }

    /**
     * Gets set of argument constrains for this argument
     *
     * @return set of argument constrains for this argument
     */
    public Set<ArgumentConstraint<T>> getConstraints() {
        //TODO
        return null;
    }

    /**
     * Gets parser for this argument
     *
     * @return parser for this argument
     */
    public ArgumentParser<T> getParser() {
        //TODO
        return null;
    }

    /**
     * Gets value of the argument
     *
     * @return value of the argument or null if the value is not set
     */
    @Nullable
    public T getValue() {
        //TODO
        return null;
    }

    /**
     * Sets the value of the argument
     *
     * @param value value to be set
     */
    void setValue(T value) {
        //TODO
    }

    /**
     * Checks whether this argument has option or not
     *
     * @return true if this argument has value, otherwise false
     */
    public boolean hasValue() {
        //TODO
        return false;
    }

    /**
     * Gets the set of error messages which occurred during parsing and possibly during constraints checking
     *
     * @return the set of error messages which occurred during parsing and possibly during constraints checking
     */
    public Set<String> getErrorMessages() {
        //TODO
        return null;
    }

    private Set<String> getParsingErrors() {
        //TODO
        return null;
    }

    private Set<String> getConstraintErrors() {
        //TODO
        return null;
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
         *
         * @param parser argument's parser
         */
        public Builder(ArgumentParser<T> parser) {
            //TODO
            this.parser = parser;
            constraints = new HashSet<ArgumentConstraint<T>>();
        }

        /**
         * Sets constraint for the argument
         *
         * @param constraint constraint to be set
         * @return Builder object
         */
        public Builder<T> addConstraint(ArgumentConstraint<T> constraint) {
            //TODO
            return null;
        }

        /**
         * Creates argument object
         *
         * @return created argument object
         */
        public Argument<T> build() {
            //TODO
            return null;
        }
    }

}
