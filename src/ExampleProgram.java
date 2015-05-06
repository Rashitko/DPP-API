import arguments.Argument;
import arguments.Constraint;
import options.Option;
import options.Parser;
import options.ParsingResult;
import parsers.IntegerParser;

import java.util.HashSet;

/**
 * Program demonstrating basic usage of the library
 */
public class ExampleProgram {
    public static void main(String[] args) {

//        Creates option representing -v or --verbose command line switch,
//        this switch is not mandatory, so it is not necessary to set it to run program
        Option verbose = new Option.Builder("v")
                .addLongSwitch("verbose")
                .setMandatory(false)
                .build();

//        Creates builder for an integer argument, which is used in next option
        Argument<Integer> iArg = new Argument.Builder<Integer>(new IntegerParser())
                .build();

        new Argument.Builder<Integer>(new IntegerParser()).
                addConstraint(new Constraint.ConstraintBuilder<Integer>(1).followedBy(2).followedBy(3))
//        Creates option representing -s or --size command line switch,
//        this option takes an integer argument,
//        this switch is not mandatory, so it is not necessary to set it to run program
        Option size = new Option.Builder("s")
                .addLongSwitch("size")
                .setMandatory(false)
                .setMandatoryArgument(iArg, "Argument size has not been set")
                .build();

//        Creates set of options, used in Parser
        HashSet<Option> optionSet = new HashSet<Option>();
        optionSet.add(verbose);
        optionSet.add(size);

//        Creates parser and then process command line argument and creates
//        parsing result, where options with their values and potentional error information
//        are stored
        Parser parser = new Parser(optionSet);
        ParsingResult result = parser.resolveOptions(args);

        //test if option verbose is resolved
        if (result.isResolvedOption(verbose)) {
            System.out.println("Verbose option has been set on the input");
        }

//        test if option size is resolved, value of size is printed if so, otherwise 42 is printed
        if (result.isResolvedOption(size)) {
            System.out.println("Value of argument size is: " + result.getResolvedOption(size).getArgument().getValue());
        } else if (result.isFailedOption(size)) {
            if (!result.getFailedOption(size).getArgument().hasValue()) {
                System.out.println("42");
            }
        }

    }

}
