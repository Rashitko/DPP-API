package parsers;

/**
 * Standard double parser
 */
public class DoubleParser extends AbstractParser<Double> {

    DoubleParser() {
        super("double");
    }

    @Override
    public Double parse(String argument) {
        this.argument = argument;
        return Double.parseDouble(argument);
    }
}
