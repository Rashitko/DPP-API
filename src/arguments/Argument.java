package arguments;

import java.util.HashSet;
import java.util.Set;

public class Argument<T> {

    private Set<ArgumentConstraint<T>> constraints;
    private ArgumentParser<T> parser;
    private T value;

    private Argument() {
        constraints = new HashSet<ArgumentConstraint<T>>();
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

    public static class Builder<T> {

        private final Argument<T> argument;

        public Builder() {
            argument = new Argument<T>();
        }

        public Builder<T> addConstraint(ArgumentConstraint<T> constraint) {
            argument.constraints.add(constraint);
            return this;
        }

        public Builder<T> setParser(ArgumentParser<T> parser) {
            argument.parser = parser;
            return this;
        }

        public Builder<T> setValue(T value) {
            argument.value = value;
            return this;
        }

        public Argument<T> build() {
            return argument;
        }
    }

}
