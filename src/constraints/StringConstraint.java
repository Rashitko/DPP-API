package constraints;

public interface StringConstraint extends OptionConstraint<String> {

    @Override
    boolean isFulfilled(String argument);
}
