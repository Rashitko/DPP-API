package DPPParser.parsers;

import DPPParser.arguments.ArgumentParser;

/**
 * Standard boolean parser
 */
public class BooleanArgumentParser implements ArgumentParser<Boolean> {

    private String argument;

    @Override
    public Boolean parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Boolean.parseBoolean(argument);
        } catch (Exception e) {
            throw new ParsingException();
        }
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as boolean";
    }
}
