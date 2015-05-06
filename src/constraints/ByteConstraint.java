package constraints;

import arguments.Constraint;

/**
 * Basic interface for all byte constraints
 */
public interface ByteConstraint extends Constraint<Byte> {

    @Override
    public boolean isFulfilled(Byte argument);
}
