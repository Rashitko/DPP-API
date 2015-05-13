package examples;

import DPPParser.arguments.Argument;
import DPPParser.arguments.Constraint;
import DPPParser.options.Option;
import DPPParser.options.OptionsList;
import DPPParser.options.Parser;
import DPPParser.parsers.IntegerArgumentParser;
import DPPParser.parsers.StringArgumentParser;

public class Main {

    public static void main(final String[] args) {
        System.out.printf("123 %b", isOption("123"));
        System.out.printf("-123 %b", isOption("-123"));
        System.out.printf("--123 %b", isOption("--123"));
        System.out.printf("123.0 %b", isOption("123.0"));
        System.out.printf("-123,0 %b", isOption("-123,0"));
        System.out.printf("--123.0 %b", isOption("--123.0"));
    }

    private static boolean isOption(String arg) {
        try {
            //noinspection ResultOfMethodCallIgnored
            Double.parseDouble(arg);
        } catch (NumberFormatException ignore) {
        }
        return arg.startsWith("-") && !arg.equals("--");
    }

}
