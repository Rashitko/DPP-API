package options;

import arguments.Argument;

import java.util.List;

public class OptionWithArgument<E> extends Option {

    public static enum ArgumentPresence {
        OPTIONAL, MANDATORY

    }

    private final Argument<E> argument;
    private final ArgumentPresence argumentPresence;

    public OptionWithArgument(Argument argument, ArgumentPresence argumentPresence) {
        this.argument = argument;
        this.argumentPresence = argumentPresence;
    }

    @Override
    public boolean hasArgument() {
        return false;
    }

    @Override
    public List<String> getShortOptions() {
        return null;
    }

    public E getArgument() {
        return argument.getValue();
    }

}
