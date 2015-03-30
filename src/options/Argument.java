package options;

import constraints.ArgumentConstraint;
import parsers.ArgumentParser;

import java.util.HashSet;
import java.util.Set;

public class Argument<T> {

    private final Set<ArgumentConstraint<T>> constraints;
    private final ArgumentParser<T> parser;
    private T value;

    private Argument(Builder<T> builder) {
        constraints = builder.constraints;
        parser = builder.parser;
    }

    public Set<ArgumentConstraint<T>> getConstraints() {
        return constraints;
    }

    public ArgumentParser<T> getParser() {
        return parser;
    }

    public T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    public Set<String> getErrorMessage() {
        HashSet<String> result = new HashSet<String>();
        for (ArgumentConstraint<T> constraint : constraints) {
            if (!constraint.isFulfilled(getValue())) {
                result.add(constraint.getErrorMessage(getValue()));
            }
        }
        return result;
    }

    public static class Builder<T> {

        private final Set<ArgumentConstraint<T>> constraints;
        private final ArgumentParser<T> parser;

        public Builder(ArgumentParser<T> parser) {
            this.parser = parser;
            constraints = new HashSet<ArgumentConstraint<T>>();
        }

        public Builder<T> addConstraint(ArgumentConstraint<T> constraint) {
            this.constraints.add(constraint);
            return this;
        }

        public Argument<T> build() {
            return new Argument<T>(this);
        }
    }

}
