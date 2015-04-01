package constraints;

/**
 * Basic interface for all short constrains
 */
public interface ShortConstraint extends ArgumentConstraint<Short> {

    @Override
    public boolean isFulfilled(Short argument);
}
