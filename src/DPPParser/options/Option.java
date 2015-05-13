package DPPParser.options;


import DPPParser.arguments.Argument;

import javax.annotation.Nullable;
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
    private ParseResult parseResult;

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
     * @return the copy of set of all short switches
     */
    public Set<String> getShortSwitches() {
        return new HashSet<String>(shortSwitches);
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
        return new HashSet<String>(longSwitches);
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
     * Checks whether this option has a mandatory argument
     *
     * @return true if this option has a mandatory argument, false otherwise
     */
    public boolean hasMandatoryArgument() {
        return argumentPresence == ArgumentPresence.MANDATORY;
    }

    /**
     * Gets the {@link Argument} associated with this option
     *
     * @return the {@link Argument} associated with this option or null if this option does not take any argument
     */
    @Nullable
    public Argument getArgument() {
        return argument;
    }

    /**
     * @return true if has an {@link Argument}
     */
    public boolean hasArgument() {
        return argument != null;
    }

    /**
     * Checks if this option has mandatory or optional {@link Argument}
     *
     * @return the enum containing the information whether this option has mandatory or optional argument,
     * returns null if this option does not take any argument
     * @see ArgumentPresence
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
     * Gets the error message which occurred during parsing and possibly during constraints checking,
     * or when mandatory argument is not present
     *
     * @return the error message which occurred during parsing and possibly during constraints checking,
     * or when mandatory argument is not present or null if no error have occurred
     */
    @Nullable
    public String getErrorMessage() {
        if (argumentPresence != null) {
            switch (argumentPresence) {
                case MANDATORY:
                    if (!argument.hasValue()) {
                        return messageArgMissing;
                    } else {
                        return argument.getErrorMessage();
                    }
                case OPTIONAL:
                    if (argument.hasValue()) {
                        return argument.getErrorMessage();
                    }
            }
        }
        return null;
    }

    /**
     * Gets parse result
     *
     * @return parse result, or null if option is not mandatory and wasn't set
     * @see ParseResult
     */
    @Nullable
    public ParseResult getParseResult() {
        return parseResult;
    }

    /**
     * Used by parser to set {@link ParseResult}
     *
     * @param parseResult parse result which will be set
     */
    void setParseResult(ParseResult parseResult) {
        this.parseResult = parseResult;
    }

    /**
     *
     * @return true if {@link Option#getParseResult()} returns
     * {@link DPPParser.options.Option.ParseResult#SUCCESS} or {@link DPPParser.options.Option.ParseResult#EXTRA}
     */
    public boolean isSuccessful() {
        return parseResult == ParseResult.SUCCESS || parseResult == ParseResult.EXTRA;
    }

    /**
     * @return false if {@link Option#getParseResult()} returns
     * {@link DPPParser.options.Option.ParseResult#SUCCESS} or {@link DPPParser.options.Option.ParseResult#EXTRA},
     * true otherwise
     */
    public boolean isFailed() {
        return parseResult != ParseResult.SUCCESS && parseResult != ParseResult.EXTRA;
    }

    /**
     * @return true if {@link Option#getParseResult()} returns
     * {@link DPPParser.options.Option.ParseResult#EXTRA},
     * false otherwise
     */
    public boolean isExtra() {
        return parseResult == ParseResult.EXTRA;
    }

    /**
     * @return true if {@link Option#getParseResult()} returns
     * {@link DPPParser.options.Option.ParseResult#OPTION_MISSED},
     * false otherwise
     */
    public boolean isMissed() {
        return parseResult == ParseResult.OPTION_MISSED;
    }


    /**
     * Represents whether argument is mandatory or optional for particular option
     */
    public enum ArgumentPresence {
        /**
         * Set when argument is not mandatory
         */
        OPTIONAL,

        /**
         * Set when argument is mandatory, therefore must be also set on command line
         */
        MANDATORY
    }

    /**
     * Represents result of parsing process
     */
    public enum ParseResult {
        /**
         * Set when everything was without problems.
         */
        SUCCESS,

        /**
         * Set when option was not defined in {@link DPPParser.options.OptionsList},
         * but was set in command line. Such option is treated as an {@link Option} with an optional
         * {@link Argument}&lt;String&gt; without {@link DPPParser.arguments.Constraint}.
         */
        EXTRA,

        /**
         * Set when option has mandatory argument, but this argument was not set on command line.
         */
        ARGUMENT_MISSED,

        /**
         * Set when option is mandatory, but was not set on command line.
         */
        OPTION_MISSED,

        /**
         * Set when parsing succeeded, but the value doesn't fulfill the {@link DPPParser.arguments.Constraint}
         */
        CONSTRAINT_FAILED,

        /**
         * Set when parsing failed, for example because of an {@link java.lang.NumberFormatException}
         */
        PARSING_FAILED
    }

    /**
     * Builder class which is used to create new options
     */
    public static class Builder {

        private static final String SWITCH_VALIDATION_REGEX = "^[a-zA-Z]+([\\w\\-_a-zA-Z_0-9]*[\\w_a-zA-Z_0-9]+|[\\w_a-zA-Z_0-9]*)$";

        private final Set<String> shortSwitches;
        private final Set<String> longSwitches;
        private boolean mandatory;
        private Argument argument;
        private ArgumentPresence argumentPresence = null;
        private String description;
        private String messageArgMissing;

        /**
         * Used by parser to create extra options which are passed on command line.
         * Note that this option might not have valid switch.
         *
         * @param optionSwitch       string representation of switch
         * @param switchType         type of switch, ie if the short or long switch should be set
         * @param overrideValidation if true, then no switch validation will be executed
         */
        Builder(String optionSwitch, SwitchType switchType, boolean overrideValidation) {
            if (!overrideValidation && !validateSwitch(optionSwitch)) {
                throw new IllegalArgumentException(getIllegalSwitchExceptionMessage(optionSwitch));
            }
            this.shortSwitches = new HashSet<String>();
            this.longSwitches = new HashSet<String>();
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
         * Sets the short switch. This short switch must be valid.
         * Valid switches must fulfill following criteria:
         * <ul>
         * <li>starts with non-empty sequence of letters</li>
         * <li>then sequence of letters, numbers and '-' can follow, but '-' must not be the last character</li>
         * </ul>
         * Note that the switches are defined without leading '-' or '--' in case of the long switches
         *
         * @param shortSwitch short switch
         */
        public Builder(String shortSwitch) {
            if (!validateSwitch(shortSwitch)) {
                throw new IllegalArgumentException(getIllegalSwitchExceptionMessage(shortSwitch));
            }
            this.shortSwitches = new HashSet<String>();
            this.shortSwitches.add(shortSwitch);
            longSwitches = new HashSet<String>();
        }

        /**
         * Sets the list of short switches
         * Valid switches must fulfill following criteria:
         * <ul>
         * <li>starts with non-empty sequence of letters</li>
         * <li>then sequence of letters, numbers and '-' can follow, but '-' must not be the last character</li>
         * </ul>
         * Note that the switches are defined without leading '-' or '--' in case of the long switches
         *
         * @param shortSwitches the list of short switches
         */
        public Builder(Set<String> shortSwitches) {
            for (String switchString : shortSwitches) {
                if (!validateSwitch(switchString)) {
                    throw new IllegalArgumentException(getIllegalSwitchExceptionMessage(switchString));
                }
            }
            this.shortSwitches = new HashSet<String>();
            this.shortSwitches.addAll(shortSwitches);
            longSwitches = new HashSet<String>();
        }

        /**
         * Sets the short or long switch.
         * Valid switches must fulfill following criteria:
         * <ul>
         * <li>starts with non-empty sequence of letters</li>
         * <li>then sequence of letters, numbers and '-' can follow, but '-' must not be the last character</li>
         * </ul>
         * Note that the switches are defined without leading '-' or '--' in case of the long switches
         *
         * @param optionSwitch switch
         * @param switchType   switch type, ie if the short or long switch should be set
         */
        public Builder(String optionSwitch, SwitchType switchType) {
            if (!validateSwitch(optionSwitch)) {
                throw new IllegalArgumentException(getIllegalSwitchExceptionMessage(optionSwitch));
            }
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
         * Sets the list of short or long switches.
         * Valid switches must fulfill following criteria:
         * <ul>
         * <li>starts with non-empty sequence of letters</li>
         * <li>then sequence of letters, numbers and '-' can follow, but '-' must not be the last character</li>
         * </ul>
         * Note that the switches are defined without leading '-' or '--' in case of the long switches
         *
         * @param optionSwitches the list of switches
         * @param switchType     switch type, ie if the list of short or long switches should be set
         */
        public Builder(Set<String> optionSwitches, SwitchType switchType) {
            for (String switchString : optionSwitches) {
                if (!validateSwitch(switchString)) {
                    throw new IllegalArgumentException(getIllegalSwitchExceptionMessage(switchString));
                }
            }
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
         * Returns exception message for illegal switch
         *
         * @param optionSwitch string representation of illegal switch
         * @return exception message
         */
        private String getIllegalSwitchExceptionMessage(String optionSwitch) {
            return "switch " + optionSwitch + " is illegal.";
        }

        /**
         * Adds short switch
         * Valid switches must fulfill following criteria:
         * <ul>
         * <li>starts with non-empty sequence of letters</li>
         * <li>then sequence of letters, numbers and '-' can follow, but '-' must not be the last character</li>
         * </ul>
         * Note that the switches are defined without leading '-' or '--' in case of the long switches
         *
         * @param shortSwitch short switch
         * @return Builder object
         */
        public Builder addShortSwitch(String shortSwitch) {
            if (!validateSwitch(shortSwitch)) {
                throw new IllegalArgumentException(getIllegalSwitchExceptionMessage(shortSwitch));
            }
            this.shortSwitches.add(shortSwitch);
            return this;
        }

        /**
         * Adds long switch
         * Valid switches must fulfill following criteria:
         * <ul>
         * <li>starts with non-empty sequence of letters</li>
         * <li>then sequence of letters, numbers and '-' can follow, but '-' must not be the last character</li>
         * </ul>
         * Note that the switches are defined without leading '-' or '--' in case of the long switches
         *
         * @param longSwitch long switch
         * @return Builder object
         */
        public Builder addLongSwitch(String longSwitch) {
            if (!validateSwitch(longSwitch)) {
                throw new IllegalArgumentException(getIllegalSwitchExceptionMessage(longSwitch));
            }
            this.longSwitches.add(longSwitch);
            return this;
        }

        /**
         * Adds the list of short switches
         * Valid switches must fulfill following criteria:
         * <ul>
         * <li>starts with non-empty sequence of letters</li>
         * <li>then sequence of letters, numbers and '-' can follow, but '-' must not be the last character</li>
         * </ul>
         * Note that the switches are defined without leading '-' or '--' in case of the long switches
         *
         * @param shortSwitches the list of short switches
         * @return Builder object
         */
        public Builder addShortSwitches(Set<String> shortSwitches) {
            for (String switchString : shortSwitches) {
                if (!validateSwitch(switchString)) {
                    throw new IllegalArgumentException(getIllegalSwitchExceptionMessage(switchString));
                }
            }
            this.shortSwitches.addAll(shortSwitches);
            return this;
        }

        /**
         * Adds the list of long switches
         * Valid switches must fulfill following criteria:
         * <ul>
         * <li>starts with non-empty sequence of letters</li>
         * <li>then sequence of letters, numbers and '-' can follow, but '-' must not be the last character</li>
         * </ul>
         * Note that the switches are defined without leading '-' or '--' in case of the long switches
         *
         * @param longSwitches the list of long switches
         * @return Builder object
         */
        public Builder addLongSwitches(Set<String> longSwitches) {
            for (String switchString : longSwitches) {
                if (!validateSwitch(switchString)) {
                    throw new IllegalArgumentException(getIllegalSwitchExceptionMessage(switchString));
                }
            }
            this.longSwitches.addAll(longSwitches);
            return this;
        }

        /**
         * Validates switch
         *
         * @param optionSwitch string representation of switch which will be validated
         * @return true if switch matches {@link DPPParser.options.Option.Builder#SWITCH_VALIDATION_REGEX}
         */
        private boolean validateSwitch(String optionSwitch) {
            return optionSwitch.matches(SWITCH_VALIDATION_REGEX);
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
         * @param argument          argument
         * @param messageArgMissing Message which will be shown when argument is not entered
         * @return Builder object
         */
        public Builder setMandatoryArgument(Argument argument, String messageArgMissing) {
            if (argument == null) {
                throw new IllegalArgumentException("argument cannot be null");
            }
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
            if (argument == null) {
                throw new IllegalArgumentException("argument cannot be null");
            }
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

            /**
             * Set if switch should be a short switch
             */
            SHORT_SWITCH,

            /**
             * Set if switch should be a long switch
             */
            LONG_SWITCH
        }

    }
}
