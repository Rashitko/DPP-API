package parsers;


import arguments.Parser;

/**
 * Standard string parser
 */
public class StringParser implements Parser<String> {

    private String argument;

    @Override
    public String parse(String argument) {
        this.argument = argument;
        return argument;
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as string";
    }
}
