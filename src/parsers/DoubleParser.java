package parsers;

import arguments.Parser;

/**
 * Standard double parser
 */
public class DoubleParser implements Parser<Double> {

    private String argument;

    @Override
    public Double parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Double.parseDouble(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as double";
    }
}
