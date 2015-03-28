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

    private Option(Set<String> shortOptions, Set<String> longOptions, boolean required) {
        this.shortOptions = shortOptions;
        this.longOptions = longOptions;
        this.required = required;
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

        private final Option option;

        public Builder(Set<String> shortOptions) {
            this.option = new Option(shortOptions, new HashSet<String>(), false);
        }

        public Builder addShortOption(String shortOption) {
            option.shortOptions.add(shortOption);
            return this;
        }

        public Builder addLongOption(String longOption) {
            option.longOptions.add(longOption);
            return this;
        }

        public Builder setRequired(boolean required) {
            option.required = required;
            return this;
        }

        public Builder setArgument(Argument argument, ArgumentPresence presence) {
            option.argument = argument;
            option.argumentPresence = presence;
            return this;
        }

        public Option build() {
            return option;
        }

    }
}
