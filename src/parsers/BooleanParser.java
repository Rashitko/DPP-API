package parsers;

import java.text.ParseException;

/**
 * Standard boolean parser
 */
public class BooleanParser extends AbstractParser<Boolean> {

    public BooleanParser() {
        super("boolean");
    }

    @Override
    public Boolean parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Boolean.parseBoolean(argument);
        } catch (Exception e) {
            throw new ParsingException();
        }
    }
}
