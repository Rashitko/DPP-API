package constraints;

import java.util.HashSet;

public class AllowedSetConstraint<T> extends HashSet<T> implements ArgumentConstraint<T> {

    @Override
    public boolean isFulfilled(T argument) {
        return contains(argument);
    }
}
