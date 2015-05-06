package DPPParser.defaultConstrains;

import DPPParser.arguments.Constraint;

/**
 * Basic interface for all string constrains
 */
public interface StringConstraint extends Constraint<String> {

    @Override
    boolean isFulfilled(String argument);
}
