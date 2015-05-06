package parsers;

import arguments.Parser;

/**
 * Standard float parser
 */
public class FloatParser implements Parser<Float> {

    private String argument;

    @Override
    public Float parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Float.parseFloat(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as float";
    }
}
