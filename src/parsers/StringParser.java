package parsers;

/**
 * Standard string parser
 */
public class StringParser extends AbstractParser<String> {

    public StringParser() {
        super("string");
    }

    @Override
    public String parse(String argument) {
        this.argument = argument;
        return argument;
    }
}
