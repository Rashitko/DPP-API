package constraints;

import arguments.ArgumentConstraint;

public interface StringConstraint extends ArgumentConstraint<String> {

    @Override
    boolean isFulfilled(String argument);
}
