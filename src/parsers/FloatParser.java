package parsers;

/**
 * Standard float parser
 */
public class FloatParser extends AbstractParser<Float> {

    public FloatParser() {
        super("float");
    }

    @Override
    public Float parse(String argument) {
        this.argument = argument;
        return Float.parseFloat(argument);
    }
}
