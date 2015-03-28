package arguments;

import java.util.HashSet;
import java.util.Set;

public class Argument<T> {

    private final Set<ArgumentConstraint<T>> constraints;
    private final ArgumentParser<T> parser;
    private T value;

    private Argument(Builder<T> builder) {
        constraints = builder.constraints;
        parser = builder.parser;
        value = builder.value;
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

    public void setValue(T value) {
        this.value = value;
    }

    public static class Builder<T> {

        private final Set<ArgumentConstraint<T>> constraints;
        private ArgumentParser<T> parser;
        private T value;

        public Builder() {
            constraints = new HashSet<ArgumentConstraint<T>>();
        }

        public Builder<T> addConstraint(ArgumentConstraint<T> constraint) {
            this.constraints.add(constraint);
            return this;
        }

        public Builder<T> setParser(ArgumentParser<T> parser) {
            this.parser = parser;
            return this;
        }

        public Builder<T> setValue(T value) {
            this.value = value;
            return this;
        }

        public Argument<T> build() {
            return new Argument<T>(this);
        }
    }

}
