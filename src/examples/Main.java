package examples;

import DPPParser.arguments.Argument;
import DPPParser.arguments.Constraint;
import DPPParser.options.Option;
import DPPParser.options.Parser;
import DPPParser.parsers.IntegerArgumentParser;
import DPPParser.parsers.StringArgumentParser;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(final String[] args) {
        //-short option --long-option --uberlongoption 123456
        Option shortOption = new Option.Builder("short")
                .setMandatoryArgument(new Argument<String>(new StringArgumentParser()), "")
                .build();
        Option longOption = new Option.Builder("long-option", Option.Builder.SwitchType.LONG_SWITCH).build();
        Option uberLong = new Option.Builder("uberlongoption", Option.Builder.SwitchType.LONG_SWITCH)
                .setOptionalArgument(new Argument<Integer>(new Constraint<Integer>() {
                    @Override
                    public boolean isFulfilled(Integer argument) {
                        return argument > 100000 && argument < 200000;
                    }

                    @Override
                    public String getErrorMessage(Integer argument) {
                        return "Should be between 100 000 and 200 000";
                    }
                }, new IntegerArgumentParser()))
                .build();
        Set<Option> options = new HashSet<Option>();
        options.add(longOption);
        options.add(shortOption);
        options.add(uberLong);
        Parser parser = new Parser(options);
        parser.resolveOptions(args);
        System.out.println();
    }

}
