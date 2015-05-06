package parsers;

import arguments.Parser;

/**
 * Standard short parser
 */
public class ShortParser implements Parser<Short> {

    private String argument;
    @Override
    public Short parse(String argument) {
        this.argument = argument;
        return Short.parseShort(argument);
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as short";
    }
}
