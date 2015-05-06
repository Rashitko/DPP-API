package parsers;

import arguments.Parser;

/**
 * Standard double parser
 */
public class DoubleParser implements Parser<Double> {

    private String argument;

    @Override
    public Double parse(String argument) {
        this.argument = argument;
        return Double.parseDouble(argument);
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as double";
    }
}
