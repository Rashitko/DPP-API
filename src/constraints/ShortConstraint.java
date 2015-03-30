package constraints;

public interface ShortConstraint extends ArgumentConstraint<Short> {

    @Override
    public boolean isFulfilled(Short argument);
}
