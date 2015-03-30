package parsers;

public class StringParser extends AbstractParser<String> {

    StringParser() {
        super("string");
    }

    @Override
    public String parse(String argument) {
        this.argument = argument;
        return argument;
    }
}
