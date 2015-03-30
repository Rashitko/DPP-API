package options;

import java.util.HashSet;
import java.util.Set;

public class Option {

    private final Set<String> shortSwitches;
    private final Set<String> longSwitches;
    private final boolean required;
    private final Argument argument;
    private final Option.ArgumentPresence argumentPresence;

    private Option(Builder builder) {
        this.shortSwitches = builder.shortSwitches;
        this.longSwitches = builder.longSwitches;
        this.required = builder.required;
        this.argument = builder.argument;
        this.argumentPresence = builder.argumentPresence;
    }

    public boolean hasShortSwitch(Option option) {
        //TODO: Check if shortSwitches contains option
        return false;
    }

    public Set<String> getShortSwitches() {
        return shortSwitches;
    }

    public boolean hasLongSwitch(Option option) {
        //TODO: Check if longSwitches contains option
        return false;
    }

    public Set<String> getLongSwitches() {
        return longSwitches;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean hasArgument() {
        //TODO:
        return argument != null;
    }

    public Argument getArgument() {
        return argument;
    }

    public ArgumentPresence getArgumentPresence() {
        return argumentPresence;
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

    public static class Builder {

        private final Set<String> shortSwitches;
        private final Set<String> longSwitches;
        private boolean required;
        private Argument argument;
        private Option.ArgumentPresence argumentPresence = ArgumentPresence.OPTIONAL;

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

        public Option build() {
            return new Option(this);
        }

        public enum SwitchType {
            SHORT_SWITCH, LONG_SWITCH
        }

    }
}
