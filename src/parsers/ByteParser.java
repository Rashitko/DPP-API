package parsers;


/**
 * Standard byte parser
 */
public class ByteParser extends AbstractParser<Byte> {

    public ByteParser() {
        super("byte");
    }

    @Override
    public Byte parse(String argument) {
        this.argument = argument;
        return Byte.parseByte(argument);
    }
}
