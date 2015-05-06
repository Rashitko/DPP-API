package constraints;

import arguments.Constraint;

/**
 * This class represent constraint which is fulfilled when the argument value is empty
 */
public class EmptyArgumentConstraint implements Constraint<String> {

    @Override
    public boolean isFulfilled(String argument) {
        return argument == null || argument.equals("");
    }

    @Override
    public String getErrorMessage(String argument) {
        //TODO:
        return "Argument value\"" + argument + "\" is not empty, when it should be";
    }
}
