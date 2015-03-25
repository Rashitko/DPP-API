package constraints;

public class EmptyArgumentConstraint implements OptionConstraint<String> {

    @Override
    public boolean isFulfilled(String argument) {
        return argument == null || argument.equals("");
    }
}
