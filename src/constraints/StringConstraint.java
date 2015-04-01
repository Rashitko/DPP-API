package constraints;

/**
 * Basic interface for all string constrains
 */
public interface StringConstraint extends ArgumentConstraint<String> {

    @Override
    boolean isFulfilled(String argument);
}
