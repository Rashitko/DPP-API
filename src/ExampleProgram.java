import options.Argument;
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
        Option verbose = new Option.Builder("v")
                .addLongSwitch("verbose")
                .setMandatory(false)
                .build();

        Argument<Integer> iArg = new Argument.Builder<Integer>(new IntegerParser())
                .build();

        Option size = new Option.Builder("s")
                .addLongSwitch("size")
                .setMandatory(false)
                .setMandatoryArgument(iArg, "Argument size has not been set")
                .build();

        HashSet<Option> optionSet = new HashSet<Option>();
        optionSet.add(verbose);
        optionSet.add(size);

        Parser parser = new Parser(optionSet);
        ParsingResult result = parser.resolveOptions(args);

        if (result.isResolvedOption(verbose)) {
            System.out.println("Verbose option has been set on the input");
        }

        if (result.isResolvedOption(size)) {
            System.out.println("Value of argument size is: " + result.getResolvedOption(size).getArgument().getValue());
        } else if (result.isFailedOption(size)) {
            if (!result.getFailedOption(size).getArgument().hasValue()) {
                System.out.println("42");
            }
        }


    }

}
