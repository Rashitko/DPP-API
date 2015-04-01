package constraints;

import java.util.HashSet;

/**
 * This constraint is used to specify a list of allowed elements, from which the given argument have to be later selected.
 *
 * @param <T> Type of the element in the list containing the allowed elements
 */
public class AllowedSetConstraint<T> extends HashSet<T> implements ArgumentConstraint<T> {

    @Override
    public boolean isFulfilled(T argument) {
        //TODO
        return false;
    }

    @Override
    public String getErrorMessage(T argument) {
        //TODO
        return null;
    }
}
