package constraints;

import arguments.ArgumentConstraint;

public interface ByteConstraint extends ArgumentConstraint<Byte> {

    @Override
    public boolean isFulfilled(Byte argument);
}
