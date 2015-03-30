package options;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represent the option
 */
public class Option {

    private final Set<String> shortSwitches;
    private final Set<String> longSwitches;
    private final boolean required;
    private final Argument argument;
    private final Option.ArgumentPresence argumentPresence;
    private final String description;
    private ParseError parseError;

    /**
     * This private constructor sets all the properties according to the Builder object on the input
     *
     * @param builder builder from which the properties are set
     */
    private Option(Builder builder) {
        this.shortSwitches = builder.shortSwitches;
        this.longSwitches = builder.longSwitches;
        this.required = builder.required;
        this.argument = builder.argument;
        this.argumentPresence = builder.argumentPresence;
        this.description = builder.description;
    }

    /**
     * Checks whether this option has one particular short switch alternative
     *
     * @param shortSwitch short switch
     * @return true if the option contains given short switch, otherwise false
     */
    public boolean hasShortSwitch(String shortSwitch) {
        //TODO: Check if shortSwitches contains option
        return false;
    }

    /**
     * Gets the set of all short switches
     * @return the set of all short switches
     */
    public Set<String> getShortSwitches() {
        return shortSwitches;
    }

    /**
     * Checks whether this option has one particular long switch alternative
     *
     * @param longSwitch short switch
     * @return true if the option contains given long switch, otherwise false
     */
    public boolean hasLongSwitch(String longSwitch) {
        //TODO: Check if longSwitches contains option
        return false;
    }

    /**
     * Gets the set of all long switches
     * @return the set of all long switches
     */
    public Set<String> getLongSwitches() {
        return longSwitches;
    }

    /**
     * Checks whether is this option mandatory or not
     * @return true if this option is mandatory, otherwise false
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * Checks whether this option takes argument
     * @return true if this option does take an argument, otherwise false
     */
    public boolean hasArgument() {
        //TODO:
        return argument != null;
    }

    /**
     * Gets the argument associated with this option
     * @return the argument associated with this option
     */
    public Argument getArgument() {
        return argument;
    }

    /**
     * Checks if this option has mandatory, optional of forbidden argument
     * @return the enum containing the information whether this option has mandatory, optional of forbidden argument
     */
    public ArgumentPresence getArgumentPresence() {
        return argumentPresence;
    }

    /**
     * Gets the option description
     * @return the option description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
//        TODO: Redefine equals
//        if (this == o) return true;
//        if (!(o instanceof Option)) return false;
//
//        Option option = (Option) o;
//
//        if (!longSwitches.equals(option.longSwitches)) return false;
//        if (!shortSwitches.equals(option.shortSwitches)) return false;
//
//        return true;
        return false;
    }

    @Override
    public int hashCode() {
//        TODO: Redefine hashCode
//        int result = shortSwitches.hashCode();
//        result = 31 * result + longSwitches.hashCode();
//        return result;
        return super.hashCode();
    }

    public static enum ArgumentPresence {
        OPTIONAL, REQUIRED, FORBIDDEN
    }

    public static enum ParseError {
        MISSING_ARGUMENT, WRONG_ARGUMENT_TYPE, FAILED_CONSTRAINT
    }

    public static class Builder {

        private final Set<String> shortSwitches;
        private final Set<String> longSwitches;
        private boolean required;
        private Argument argument;
        private Option.ArgumentPresence argumentPresence = ArgumentPresence.OPTIONAL;
        private String description;

        public Builder(String shortSwitch) {
            this.shortSwitches = new HashSet<String>();
            this.shortSwitches.add(shortSwitch);
            longSwitches = new HashSet<String>();
        }

        public Builder(Set<String> shortSwitches) {
            this.shortSwitches = new HashSet<String>();
            this.shortSwitches.addAll(shortSwitches);
            longSwitches = new HashSet<String>();
        }

        public Builder(String optionSwitch, SwitchType switchType) {
            this.shortSwitches = new HashSet<String>();
            longSwitches = new HashSet<String>();
            switch (switchType) {
                case SHORT_SWITCH:
                    shortSwitches.add(optionSwitch);
                    break;
                case LONG_SWITCH:
                    longSwitches.add(optionSwitch);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown switchType: " + switchType);
            }
        }

        public Builder(Set<String> optionSwitches, SwitchType switchType) {
            this.shortSwitches = new HashSet<String>();
            longSwitches = new HashSet<String>();
            switch (switchType) {
                case SHORT_SWITCH:
                    shortSwitches.addAll(optionSwitches);
                    break;
                case LONG_SWITCH:
                    longSwitches.addAll(optionSwitches);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown switchType: " + switchType);
            }
        }

        public Builder addShortSwitch(String shortSwitch) {
            this.shortSwitches.add(shortSwitch);
            return this;
        }

        public Builder addLongSwitch(String longSwitch) {
            this.longSwitches.add(longSwitch);
            return this;
        }

        public Builder addShortSwitches(Set<String> shortSwitches) {
            this.shortSwitches.addAll(shortSwitches);
            return this;
        }

        public Builder addLongSwitches(Set<String> longSwitches) {
            this.longSwitches.addAll(longSwitches);
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

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Option build() {
            return new Option(this);
        }

        public enum SwitchType {
            SHORT_SWITCH, LONG_SWITCH
        }

    }
}
