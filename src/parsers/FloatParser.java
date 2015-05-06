package parsers;

/**
 * Standard float parser
 */
public class FloatParser extends AbstractParser<Float> {

    public FloatParser() {
        super("float");
    }

    @Override
    public Float parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Float.parseFloat(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }
}
