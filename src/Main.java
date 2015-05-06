import options.Argument;
import options.Option;
import options.Parser;
import parsers.IntegerParser;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Option option = new Option.Builder("short", Option.Builder.SwitchType.LONG_SWITCH)
                .setMandatoryArgument(new Argument.Builder<Integer>(new IntegerParser()).build(), "should be 123")
                .build();
        Set<Option> options = new HashSet<Option>();
        options.add(option);
        Parser parser = new Parser(options);
        parser.resolveOptions(args);
        System.out.println();
    }

}
