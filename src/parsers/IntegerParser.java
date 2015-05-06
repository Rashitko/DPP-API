package parsers;

import arguments.Parser;

/**
 * Standard integer parser
 */
public class IntegerParser implements Parser<Integer> {

    private String argument;

    @Override
    public Integer parse(String argument) {
        this.argument = argument;
        return Integer.parseInt(argument);
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as integer";
    }

}
