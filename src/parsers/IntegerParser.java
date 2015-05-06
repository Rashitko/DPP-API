package parsers;

/**
 * Standard integer parser
 */
public class IntegerParser extends AbstractParser<Integer> {

    public IntegerParser() {
        super("int");
    }

    @Override
    public Integer parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Integer.parseInt(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }

}
