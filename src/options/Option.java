package options;

import java.util.List;

abstract class Option {

    private final List<String> shortOptions;
    private final List<String> longOptions;
    private final boolean isOptional;

    public abstract boolean hasArgument();

    public abstract

    public List<String> getShortOptions() {
        return shortOptions;
    }

    public List<String> getLongOptions() {
        return longOptions;
    }

    public boolean isOptional() {
        return isOptional;
    }
}
