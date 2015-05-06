package defaultConstraints;

import arguments.Constraint;

import java.util.HashSet;

/**
 * This constraint is used to specify a list of allowed elements, from which the given argument have to be later selected.
 *
 * @param <T> Type of the element in the list containing the allowed elements
 */
public class AllowedSetConstraint<T> extends HashSet<T> implements Constraint<T> {

    @Override
    public boolean isFulfilled(T argument) {
        return contains(argument);
    }

    @Override
    public String getErrorMessage(T argument) {
        return argument + " is not allowed. Allowed arguments are:" + this;
    }
}
