package DPPParser.parsers;

import DPPParser.arguments.ArgumentParser;

/**
 * Standard integer parser
 */
public class IntegerArgumentParser implements ArgumentParser<Integer> {

    private String argument;

    @Override
    public Integer parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Integer.parseInt(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as integer";
    }

}
