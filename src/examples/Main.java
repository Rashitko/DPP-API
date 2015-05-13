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

    public static void main(final String[] args) {

        Option verbose = new Option.Builder("v")
                .addLongSwitch("verbose")
                .build();
        Option size = new Option.Builder("s")
                .addLongSwitch("size")
                .setOptionalArgument(new Argument<Integer>(new LowerBoundConstraint<Integer>(SIZE_LOWER_BOUND), new IntegerArgumentParser()))
                .build();

        OptionsList options = new OptionsList();
        options.add(verbose);
        options.add(size);
        Parser parser = new Parser(options);
        parser.resolveOptions(args);
        System.out.println("verbose = " + verbose.isSuccessful());
        System.out.println("size = " + size.getArgument().getValue());
        List<String> unmatchedAndRegular = new ArrayList<String>(parser.getUnmatchedArguments());
        unmatchedAndRegular.addAll(parser.getRegularArguments());
        if (!unmatchedAndRegular.isEmpty()) {
            System.out.println(unmatchedAndRegular);
        }
    }

}
