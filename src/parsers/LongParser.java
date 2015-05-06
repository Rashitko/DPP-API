package parsers;

import arguments.Parser;

/**
 * Standard long parser
 */
public class LongParser implements Parser<Long> {

    private String argument;

    @Override
    public Long parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Long.parseLong(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as long";
    }
}
