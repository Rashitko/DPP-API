package options;

import constraints.StringConstraint;

import java.util.List;

public class StringOption extends Option {
    public StringOption(String shortOption, List<String> longOptions,
                        StringConstraint constraint, boolean optional) {
        super(shortOption, longOptions, constraint, optional);
    }

    public StringOption(String shortOption, StringConstraint constraint, boolean optional) {
        super(shortOption, null, constraint, optional);
    }

    public StringOption(String shortOption, List<String> longOptions, boolean optional) {
        super(shortOption, longOptions, null, optional);
    }

    public StringOption(String shortOption, boolean optional) {
        super(shortOption, null, null, optional);
    }
}
