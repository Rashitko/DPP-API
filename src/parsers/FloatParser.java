package parsers;

import arguments.Parser;

/**
 * Standard float parser
 */
public class FloatParser implements Parser<Float> {

    private String argument;

    @Override
    public Float parse(String argument) {
        this.argument = argument;
        return Float.parseFloat(argument);
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as float";
    }
}
