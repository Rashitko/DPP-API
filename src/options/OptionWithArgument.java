package options;

import arguments.ArgumentType;

public class OptionWithArgument extends Option {

    public static enum ArgumentPresence {
        OPTIONAL, MANDATORY;
    }

    private final ArgumentType argument;
    private final ArgumentPresence argumentPresence;

}
