package parsers;

/**
 * Standard boolean parser
 */
public class BooleanParser extends AbstractParser<Boolean> {

    public BooleanParser() {
        super("boolean");
    }

    @Override
    public Boolean parse(String argument) {
        this.argument = argument;
        return Boolean.parseBoolean(argument);
    }
}
