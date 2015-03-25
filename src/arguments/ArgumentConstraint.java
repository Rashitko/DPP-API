package arguments;

public interface ArgumentConstraint<E> {

    public boolean isFulfilled(E argument);

}
