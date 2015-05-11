package DPPParser.defaultConstrains;

import DPPParser.arguments.Constraint;

/**
 * Basic interface for all short constrains
 */
public interface ShortConstraint extends Constraint<Short> {

    @Override
    public boolean isFulfilled(Short argument);
}
