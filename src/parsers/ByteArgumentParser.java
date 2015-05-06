package parsers;


import arguments.ArgumentParser;

/**
 * Standard byte parser
 */
public class ByteArgumentParser implements ArgumentParser<Byte> {

    private String argument;

    @Override
    public Byte parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Byte.parseByte(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as byte";
    }
}
