package constraints;

/**
 * This class represent constraint which is fulfilled when the argument value is empty
 */
public class EmptyArgumentConstraint implements ArgumentConstraint<String> {

    @Override
    public boolean isFulfilled(String argument) {
        //TODO
        return false;
    }

    @Override
    public String getErrorMessage(String argument) {
        //TODO:
        return null;
    }
}
