package parsers;

import arguments.Parser;

/**
 * Standard long parser
 */
public class LongParser implements Parser<Long> {

    private String argument;
    @Override
    public Long parse(String argument) {
        this.argument = argument;
        return Long.parseLong(argument);
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as long";
    }
}
