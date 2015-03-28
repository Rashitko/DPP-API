package constraints;

import arguments.ArgumentConstraint;

public class EmptyArgumentConstraint implements ArgumentConstraint<String> {

    @Override
    public boolean isFulfilled(String argument) {
        return argument == null || argument.equals("");
    }
}
