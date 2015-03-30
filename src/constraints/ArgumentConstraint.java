package constraints;

public interface ArgumentConstraint<E> {

    public boolean isFulfilled(E argument);

    public String getErrorMessage(E argument);

}
