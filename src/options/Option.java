package options;

import arguments.Argument;

import java.util.HashSet;
import java.util.Set;

public class Option {

    private final Set<String> shortOptions;
    private final Set<String> longOptions;
    private boolean required;
    private Argument argument;
    private Option.ArgumentPresence argumentPresence;

    private Option(Builder builder) {
        this.shortOptions = builder.shortOptions;
        this.longOptions = builder.longOptions;
        this.required = builder.required;
        this.argument = builder.argument;
        this.argumentPresence = builder.argumentPresence;
    }

    public Set<String> getShortOptions() {
        return shortOptions;
    }

    public Set<String> getLongOptions() {
        return longOptions;
    }

    public boolean isRequired() {
        return required;
    }

    public Argument getArgument() {
        return argument;
    }

    public ArgumentPresence getArgumentPresence() {
        return argumentPresence;
    }

    public boolean hasShortOption(Option option) {
        //TODO: Check if shortOptions contains option
        return false;
    }

    public boolean hasLongOption(Option option) {
        //TODO: Check if longOptions contains option
        return false;
    }

    public static enum ArgumentPresence {
        OPTIONAL, REQUIRED, FORBIDDEN
    }

    public static class Builder {

        private final Set<String> shortOptions;
        private final Set<String> longOptions;
        private boolean required;
        private Argument argument;
        private Option.ArgumentPresence argumentPresence = ArgumentPresence.OPTIONAL;

        public Builder(String shortOption) {
            this.shortOptions = new HashSet<String>();
            this.shortOptions.add(shortOption);
            longOptions = new HashSet<String>();
        }

        public Builder(Set<String> shortOptions) {
            this.shortOptions = new HashSet<String>();
            this.shortOptions.addAll(shortOptions);
            longOptions = new HashSet<String>();
        }

        public Builder addShortOption(String shortOption) {
            this.shortOptions.add(shortOption);
            return this;
        }

        public Builder addLongOption(String longOption) {
            this.longOptions.add(longOption);
            return this;
        }

        public Builder setRequired(boolean required) {
            this.required = required;
            return this;
        }

        public Builder setArgument(Argument argument, ArgumentPresence presence) {
            this.argument = argument;
            this.argumentPresence = presence;
            return this;
        }

        public Option build() {
            return new Option(this);
        }

    }
}
