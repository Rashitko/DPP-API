package options;

import constraints.OptionConstraint;

import java.util.List;

public abstract class Option {

    private final String shortOption;
    private final List<String> longOptions;
    private final OptionConstraint constraint;
    private final boolean optional;


    public Option(String shortOption, List<String> longOptions, OptionConstraint constraint, boolean optional) {
        this.shortOption = shortOption;
        this.longOptions = longOptions;
        this.constraint = constraint;
        this.optional = optional;
    }

//    public Option(String shortOption, OptionConstraint constraint, boolean optional) {
//        this.shortOption = shortOption;
//        this.longOptions = null;
//        this.constraint = constraint;
//        this.optional = optional;
//    }
//
//    public Option(String shortOption, List<String> longOptions, boolean optional) {
//        this.shortOption = shortOption;
//        this.longOptions = longOptions;
//        this.constraint = null;
//        this.optional = optional;
//    }
//
//    public Option(String shortOption, boolean optional) {
//        this.shortOption = shortOption;
//        this.longOptions = null;
//        this.constraint = null;
//        this.optional = optional;
//    }

    /**
     * Returns short option without leading "-".
     * For example for option "-v","v" will be returned.
     * @return Short option without leading "-"
     */
    public String getShortOption() {
        return shortOption;
    }

    /**
     * @return List of long aliases
     */
    public List<String> getLongOptions() {
        return longOptions;
    }

    public boolean hasLongOptions() {
        return longOptions != null && longOptions.size() > 0;
    }

    public OptionConstraint getConstraint() {
        return constraint;
    }

    public boolean isOptional() {
        return optional;
    }
}
