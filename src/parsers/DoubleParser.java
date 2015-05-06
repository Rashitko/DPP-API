package parsers;

/**
 * Standard double parser
 */
public class DoubleParser extends AbstractParser<Double> {

    public DoubleParser() {
        super("double");
    }

    @Override
    public Double parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Double.parseDouble(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }
}
