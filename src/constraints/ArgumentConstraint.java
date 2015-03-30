package constraints;

public interface ArgumentConstraint<E> {

    public boolean isFulfilled(E argument);

}
