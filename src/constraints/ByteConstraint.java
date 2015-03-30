package constraints;

/**
 * Basic interface for all byte constrains
 */
public interface ByteConstraint extends ArgumentConstraint<Byte> {

    @Override
    public boolean isFulfilled(Byte argument);
}
