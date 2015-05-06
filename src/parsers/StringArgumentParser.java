package parsers;


import arguments.ArgumentParser;

/**
 * Standard string parser
 */
public class StringArgumentParser implements ArgumentParser<String> {

    private String argument;

    @Override
    public String parse(String argument) throws ParsingException {
        this.argument = argument;
        return argument;
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as string";
    }
}
