package parsers;


/**
 * Standard byte parser
 */
public class ByteParser extends AbstractParser<Byte> {

    public ByteParser() {
        super("byte");
    }

    @Override
    public Byte parse(String argument) throws ParsingException{
        this.argument = argument;
        try {
            return Byte.parseByte(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }
}
