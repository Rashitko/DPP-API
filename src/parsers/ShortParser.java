package parsers;

public class ShortParser extends AbstractParser<Short> {

    ShortParser(String typeName) {
        super("short");
    }

    @Override
    public Short parse(String argument) {
        this.argument = argument;
        return Short.parseShort(argument);
    }
}
