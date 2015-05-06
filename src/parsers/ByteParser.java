package parsers;


import arguments.Parser;

/**
 * Standard byte parser
 */
public class ByteParser implements Parser<Byte> {

    private String argument;

    @Override
    public Byte parse(String argument) {
        this.argument = argument;
        return Byte.parseByte(argument);
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as byte";
    }
}
