package examples;


import DPPParser.arguments.Constraint;
import DPPParser.defaultConstrains.LowerBoundConstraint;

public class ExampleProgram {
    //TODO: write example program from the course page
    public static void main(final String[] args) {
        Constraint.ConstraintBuilder<Integer> builder = new Constraint.ConstraintBuilder<Integer>(new LowerBoundConstraint<Integer>(10));
    }
}
