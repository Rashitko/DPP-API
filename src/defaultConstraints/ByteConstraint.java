package defaultConstraints;

import arguments.Constraint;

/**
 * Basic interface for all byte constraints
 */
public interface ByteConstraint extends Constraint<Byte> {

    @Override
    boolean isFulfilled(Byte argument);
}
