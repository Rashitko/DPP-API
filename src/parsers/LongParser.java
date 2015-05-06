package parsers;

/**
 * Standard long parser
 */
public class LongParser extends AbstractParser<Long> {

    public LongParser() {
        super("long");
    }

    @Override
    public Long parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Long.parseLong(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }
}
