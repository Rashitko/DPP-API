package parsers;

public class LongParser extends AbstractParser<Long> {

    LongParser() {
        super("long");
    }

    @Override
    public Long parse(String argument) {
        this.argument = argument;
        return Long.parseLong(argument);
    }
}
