package options;


import arguments.Argument;
import com.sun.istack.internal.Nullable;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represent an option
 */
public class Option {

    private final Set<String> shortSwitches;
    private final Set<String> longSwitches;
    private final boolean mandatory;
    private final Argument argument;
    private final ArgumentPresence argumentPresence;
    private final String description;
    private final String messageArgMissing;
    private ParseError parseError;

    /**
     * This private constructor sets all the properties according to the Builder object on the input
     *
     * @param builder builder from which the properties are set
     */
    private Option(Builder builder) {
        this.shortSwitches = builder.shortSwitches;
        this.longSwitches = builder.longSwitches;
        this.mandatory = builder.mandatory;
        this.argument = builder.argument;
        this.argumentPresence = builder.argumentPresence;
        this.description = builder.description;
        this.messageArgMissing = builder.messageArgMissing;
    }

    /**
     * Checks whether this option has one particular short switch
     *
     * @param shortSwitch short switch
     * @return true if the option contains given short switch, otherwise false
     */
    public boolean hasShortSwitch(String shortSwitch) {
        return shortSwitches.contains(shortSwitch);
    }

    /**
     * Gets the set of all short switches
     *
     * @return the set of all short switches
     */
    public Set<String> getShortSwitches() {
        return shortSwitches;
    }

    /**
     * Checks whether this option has one particular long switch
     *
     * @param longSwitch short switch
     * @return true if the option contains given long switch, otherwise false
     */
    public boolean hasLongSwitch(String longSwitch) {
        return longSwitches.contains(longSwitch);
    }

    /**
     * Gets the set of all long switches
     *
     * @return the set of all long switches
     */
    public Set<String> getLongSwitches() {
        return longSwitches;
    }

    /**
     * Checks whether this option is mandatory or if it is not
     *
     * @return true if this option is mandatory, otherwise false
     */
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * Checks whether this option takes an argument
     *
     * @return true if this option takes an argument, otherwise false
     */
    public boolean takesArgument() {
        if (argumentPresence != null) {
            return true;
        }
        return false;
    }

    /**
     * Gets the argument associated with this option
     *
     * @return the argument associated with this option or null if this option does not take any argument
     */
    @Nullable
    public Argument getArgument() {
        return argument;
    }

    /**
     * Checks if this option has mandatory or optional argument
     *
     * @return the enum containing the information whether this option has mandatory or optional argument,
     * returns null if this option does not take any argument
     */
    public ArgumentPresence getArgumentPresence() {
        return argumentPresence;
    }

    /**
     * Gets the option description
     *
     * @return the option description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the set of error messages which occurred during parsing and possibly during constraints checking
     *
     * @return the set of error messages which occurred during parsing and possibly during constraints checking
     */
    public Set<String> getErrorMessages() {
        HashSet<String> result = new HashSet<String>();
        switch (argumentPresence) {
            case MANDATORY:
                if (!argument.hasValue()) {
                    result.add(messageArgMissing);
                } else {
                    result.addAll(argument.getErrorMessages());
                }
                break;
            case OPTIONAL:
                if (argument.hasValue()) {
                    result.addAll(argument.getErrorMessages());
                }
                break;
        }
        return result;
    }

    /**
     * +     * Gets type of parse error
     * +     *
     * +     * @return parse error, or null if no error occurred
     * +
     */
    @Nullable
    public ParseError getParseError() {
        //TODO
        return null;
    }

    /**
     * Sets parse error
     *
     * @param parseError
     */
    void setParseError(ParseError parseError) {
        //TODO
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


    /**
     * Builder class which is used to create new options
     */
    public static class Builder {

        private final Set<String> shortSwitches;
        private final Set<String> longSwitches;
        private boolean mandatory;
        private Argument argument;
        private ArgumentPresence argumentPresence = ArgumentPresence.OPTIONAL;
        private String description;
        private String messageArgMissing;

        /**
         * This constructor sets the short switch
         *
         * @param shortSwitch short switch
         */
        public Builder(String shortSwitch) {
            this.shortSwitches = new HashSet<String>();
            this.shortSwitches.add(shortSwitch);
            longSwitches = new HashSet<String>();
        }

        /**
         * This constructor sets the list of short switches
         *
         * @param shortSwitches the list of short switches
         */
        public Builder(Set<String> shortSwitches) {
            this.shortSwitches = new HashSet<String>();
            this.shortSwitches.addAll(shortSwitches);
            longSwitches = new HashSet<String>();
        }

        /**
         * This constructor sets the short or long switch.
         *
         * @param optionSwitch switch
         * @param switchType   switch type, ie if the short or long switch should be set
         */
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

        /**
         * This constructor sets the list of short or long switches.
         *
         * @param optionSwitches the list of switches
         * @param switchType     switch type, ie if the list of short or long switches should be set
         */
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

        /**
         * Adds short switch
         *
         * @param shortSwitch short switch
         * @return Builder object
         */
        public Builder addShortSwitch(String shortSwitch) {
            this.shortSwitches.add(shortSwitch);
            return this;
        }

        /**
         * Adds long switch
         *
         * @param longSwitch long switch
         * @return Builder object
         */
        public Builder addLongSwitch(String longSwitch) {
            this.longSwitches.add(longSwitch);
            return this;
        }

        /**
         * Adds the list of short switches
         *
         * @param shortSwitches the list of short switches
         * @return Builder object
         */
        public Builder addShortSwitches(Set<String> shortSwitches) {
            this.shortSwitches.addAll(shortSwitches);
            return this;
        }

        /**
         * Adds the list of long switches
         *
         * @param longSwitches the list of long switches
         * @return Builder object
         */
        public Builder addLongSwitches(Set<String> longSwitches) {
            this.longSwitches.addAll(longSwitches);
            return this;
        }

        /**
         * Sets this option to be mandatory or not
         *
         * @param mandatory true if the option is mandatory, otherwise false
         * @return Builder object
         */
        public Builder isMandatory(boolean mandatory) {
            this.mandatory = mandatory;
            return this;
        }

        /**
         * Sets the mandatory argument to the option
         *
         * @param argument argument
         * @return Builder object
         */
        public Builder setMandatoryArgument(Argument argument, String messageArgMissing) {
            this.argument = argument;
            this.argumentPresence = ArgumentPresence.MANDATORY;
            this.messageArgMissing = messageArgMissing;
            return this;
        }

        /**
         * Sets the optional argument to the option
         *
         * @param argument argument
         * @return Builder object
         */
        public Builder setOptionalArgument(Argument argument) {
            this.argument = argument;
            this.argumentPresence = ArgumentPresence.OPTIONAL;
            return this;
        }

        /**
         * Sets the option description
         *
         * @param description description
         * @return Builder object
         */
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }


        /**
         * Creates the Option object
         *
         * @return the Option object
         */
        public Option build() {
            if (description == null) {
                description = "Description is not available for this option";
            }
            return new Option(this);
        }

        /**
         * Enum used to specify if the switch is short or long
         */
        public enum SwitchType {
            SHORT_SWITCH, LONG_SWITCH
        }

    }
}
