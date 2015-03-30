package parsers;

public class FloatParser extends AbstractParser<Float> {

    FloatParser() {
        super("float");
    }

    @Override
    public Float parse(String argument) {
        this.argument = argument;
        return Float.parseFloat(argument);
    }
}
