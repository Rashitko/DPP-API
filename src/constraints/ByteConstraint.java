package constraints;

public interface ByteConstraint extends ArgumentConstraint<Byte> {

    @Override
    public boolean isFulfilled(Byte argument);
}
