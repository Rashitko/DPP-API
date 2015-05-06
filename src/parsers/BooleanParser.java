package parsers;

import arguments.Parser;

/**
 * Standard boolean parser
 */
public class BooleanParser implements Parser<Boolean> {

    private String argument;

    @Override
    public Boolean parse(String argument) {
        this.argument = argument;
        return Boolean.parseBoolean(argument);
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as boolean";
    }
}
