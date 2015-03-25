package constraints;

public interface StringConstraint extends ArgumentConstraint<String> {

    @Override
    boolean isFulfilled(String argument);
}
