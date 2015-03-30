package parsers;

public class IntegerParser extends AbstractParser<Integer> {

    IntegerParser() {
        super("int");
    }

    @Override
    public Integer parse(String argument) {
        this.argument = argument;
        return Integer.parseInt(argument);
    }

}
