package DPPParser.arguments;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents constraint which is composed of more simple constraints
 *
 * @param <T> Type of argument the constraint is applied on
 */
class ComposedConstraint<T> implements Constraint<T> {
    List<Constraint<T>> constraints;

    /**
     * @param constraints List of constrains from which the composed constrain is created
     */
    public ComposedConstraint(List<Constraint<T>> constraints) {
        this.constraints = new ArrayList<Constraint<T>>();
    }

    @Override
    public boolean isFulfilled(T argument) {
        for (Constraint<T> constraint : constraints) {
            if (!constraint.isFulfilled(argument)) {
                return false;
            }
        }
        return false;
    }

    @Override
    public String getErrorMessage(T argument) {
        StringBuilder strBuilder = new StringBuilder();
        for (Constraint<T> constraint : constraints) {
            strBuilder
                    .append(constraint.getClass().getName())
                    .append(" : ")
                    .append(constraint.getErrorMessage(argument))
                    .append(System.getProperty("line.separator"));
        }
        return strBuilder.toString();
    }
}
