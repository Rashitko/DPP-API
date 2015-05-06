package parsers;

/**
 * Standard short parser
 */
public class ShortParser extends AbstractParser<Short> {

    public ShortParser(String typeName) {
        super("short");
    }

    @Override
    public Short parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Short.parseShort(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }
}
