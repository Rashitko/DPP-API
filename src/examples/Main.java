package examples;

import DPPParser.arguments.Argument;
import DPPParser.defaultConstrains.LowerBoundConstraint;
import DPPParser.options.Option;
import DPPParser.options.OptionsList;
import DPPParser.options.Parser;
import DPPParser.parsers.IntegerArgumentParser;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int SIZE_LOWER_BOUND = 0;
    public static final int SIZE_DEFAULT = 42;

    public static void main(final String[] args) {

        // INITIALIZE OPTIONS
        final Option verbose = new Option.Builder("v")
                .addLongSwitch("verbose")
                .build();
        final Argument<Integer> sizeArg = new Argument<Integer>(
                new LowerBoundConstraint<Integer>(SIZE_LOWER_BOUND),
                new IntegerArgumentParser());
        final Option size = new Option.Builder("s")
                .addLongSwitch("size")
                .setOptionalArgument(sizeArg)
                .build();
        OptionsList options = new OptionsList();
        options.add(verbose);
        options.add(size);

        //INSTANTIATE PARSER
        Parser parser = new Parser(options);
        //RESOLVE OPTIONS
        parser.resolveOptions(args);

        //PRINT RESULTS
        System.out.println("verbose = " + verbose.isSuccessful());
        if (size.getArgument().getValue() == null) {
            System.out.println("size = " + SIZE_DEFAULT);
        } else {
            System.out.println("size = " + size.getArgument().getValue());
        }
        //merge unmatched arguments and regular arguments into one list and print it
        List<String> unmatchedAndRegular = new ArrayList<String>(parser.getUnmatchedArguments());
        unmatchedAndRegular.addAll(parser.getRegularArguments());
        if (!unmatchedAndRegular.isEmpty()) {
            System.out.println(unmatchedAndRegular);
        }
    }

}
