package DPPParser.arguments;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic interface for an argument constraint
 *
 * @param <E> Type of argument the constraint is applied on
 */
public interface Constraint<E> {

    /**
     * Test if the constraint is fulfilled
     *
     * @param argument argument on which is the constraint applied
     * @return true if the constraint is fulfilled, otherwise false
     */
    boolean isFulfilled(E argument);

    /**
     * Get the error message when constraint is not fulfilled
     *
     * @param argument argument on which is the constraint applied
     * @return the error message when constraint is not fulfilled
     */
    String getErrorMessage(E argument);

    /**
     * Constraint builder used to create composed constrains. Order of constrains evaluation is determined by the order
     * in which the constrains are added using the followedBy method. For example constraint added as the last using the
     * followedBy method will be evaluated as the last one
     *
     * @param <T> Type of argument the constraint is applied on
     */
    class ConstraintBuilder<T> {
        List<Constraint<T>> constraints = new ArrayList<Constraint<T>>();

        public ConstraintBuilder(Constraint<T> constraint) {
            constraints.add(constraint);
        }

        /**
         * Add the constraint to the composed constraint. This constraint will be evaluated after all the previously added
         * constrains during the parsing phase
         *
         * @param constraint constraint which is added on the top of previously added constrains
         * @return current constraint builder
         */
        public ConstraintBuilder<T> followedBy(Constraint<T> constraint) {
            constraints.add(constraint);
            return this;
        }

        /**
         * Build the composed constraint
         *
         * @return constraint
         */
        public Constraint<T> build() {
            return new ComposedConstraint<T>(constraints);
        }
    }

}
