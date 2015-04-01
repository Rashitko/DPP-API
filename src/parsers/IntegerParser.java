package parsers;

/**
 * Standard integer parser
 */
public class IntegerParser extends AbstractParser<Integer> {

    public IntegerParser() {
        super("int");
    }

    @Override
    public Integer parse(String argument) {
        this.argument = argument;
        return Integer.parseInt(argument);
    }

}
