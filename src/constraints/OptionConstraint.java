package constraints;

public interface OptionConstraint<E> {

    public boolean isFulfilled(E argument);

}
