package parsers;

import arguments.ArgumentParser;

/**
 * Standard short parser
 */
public class ShortArgumentParser implements ArgumentParser<Short> {

    private String argument;

    @Override
    public Short parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Short.parseShort(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as short";
    }
}
