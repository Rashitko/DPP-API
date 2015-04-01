package options;

import com.sun.istack.internal.Nullable;

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
    private final ArgumentPresence argumentPresence;
    private final String description;
    private final String messageArgMissing;

    /**
     * This private constructor sets all the properties according to the Builder object on the input
     *
     * @param builder builder from which the properties are set
     */
    private Option(Builder builder) {
        //TODO
        this.shortSwitches = builder.shortSwitches;
        this.longSwitches = builder.longSwitches;
        this.required = builder.required;
        this.argument = builder.argument;
        this.argumentPresence = builder.argumentPresence;
        this.description = builder.description;
        this.messageArgMissing = builder.messageArgMissing;
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
     *
     * @return the set of all short switches
     */
    public Set<String> getShortSwitches() {
        //TODO
        return null;
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
     *
     * @return the set of all long switches
     */
    public Set<String> getLongSwitches() {
        //TODO
        return null;
    }

    /**
     * Checks whether is this option mandatory or not
     *
     * @return true if this option is mandatory, otherwise false
     */
    public boolean isRequired() {
        //TODO
        return false;
    }

    /**
     * Checks whether this option takes argument
     *
     * @return true if this option does take an argument, otherwise false
     */
    public boolean takesArgument() {
        //TODO:
        return argument != null;
    }

    /**
     * Gets the argument associated with this option
     *
     * @return the argument associated with this option or null if this option does not take any argument
     */
    @Nullable
    public Argument getArgument() {
        //TODO
        return null;
    }

    /**
     * Checks if this option has mandatory or optional argument
     *
     * @return the enum containing the information whether this option has mandatory or optional argument,
     * returns null if this option does not take any parameter
     */
    public ArgumentPresence getArgumentPresence() {
        //TODO:
        return null;
    }

    /**
     * Gets the option description
     *
     * @return the option description
     */
    public String getDescription() {
        //TODO
        return null;
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

    @Override
    public boolean equals(Object o) {
//        TODO: Redefine equals
        return false;
    }

    @Override
    public int hashCode() {
//        TODO: Redefine hashCode
        return 0;
    }


    /**
     * Builder class which is used to create new options
     */
    public static class Builder {

        private final Set<String> shortSwitches;
        private final Set<String> longSwitches;
        private boolean required;
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
//            TODO
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
            //TODO
            this.shortSwitches = new HashSet<String>();
            longSwitches = new HashSet<String>();
        }

        /**
         * This constructor sets the short or long switch.
         *
         * @param optionSwitch switch
         * @param switchType   switch type, ie if the short or long switch should be set
         */
        public Builder(String optionSwitch, SwitchType switchType) {
            //TODO
            this.shortSwitches = new HashSet<String>();
            longSwitches = new HashSet<String>();

        }

        /**
         * This constructor sets the list of short or long switches.
         *
         * @param optionSwitches the list of switches
         * @param switchType     switch type, ie if the list of short or long switches should be set
         */
        public Builder(Set<String> optionSwitches, SwitchType switchType) {
            //TODO
            this.shortSwitches = new HashSet<String>();
            longSwitches = new HashSet<String>();
        }

        /**
         * Adds short switch
         *
         * @param shortSwitch short switch
         * @return Builder object
         */
        public Builder addShortSwitch(String shortSwitch) {
            //TODO
            return null;
        }

        /**
         * Adds long switch
         *
         * @param longSwitch long switch
         * @return Builder object
         */
        public Builder addLongSwitch(String longSwitch) {
            //TODO
            return null;
        }

        /**
         * Adds the list of short switches
         *
         * @param shortSwitches the list of short switches
         * @return Builder object
         */
        public Builder addShortSwitches(Set<String> shortSwitches) {
            //TODO
            return null;
        }

        /**
         * Adds the list of long switches
         *
         * @param longSwitches the list of long switches
         * @return Builder object
         */
        public Builder addLongSwitches(Set<String> longSwitches) {
            //TODO
            return null;
        }

        /**
         * Sets this option to be mandatory or not
         *
         * @param required true if the option is mandatory, otherwise false
         * @return Builder object
         */
        public Builder setMandatory(boolean required) {
            //TODO
            return null;
        }

        /**
         * Sets the mandatory argument to the option
         *
         * @param argument argument
         * @return Builder object
         */
        public Builder setMandatoryArgument(Argument argument, String messageArgMissing) {
            //TODO
            return null;
        }

        /**
         * Sets the optional argument to the option
         *
         * @param argument argument
         * @return Builder object
         */
        public Builder setOptionalArgument(Argument argument) {
            //TODO
            return null;
        }

        /**
         * Sets the option description
         *
         * @param description description
         * @return Builder object
         */
        public Builder setDescription(String description) {
            //TODO
            return null;
        }

        /**
         * Creates the Option object
         *
         * @return the Option object
         */
        public Option build() {
            //TODO
            return null;
        }

        /**
         * Enum used to specify if the switch is short or long
         */
        public enum SwitchType {
            SHORT_SWITCH, LONG_SWITCH
        }

    }
}
