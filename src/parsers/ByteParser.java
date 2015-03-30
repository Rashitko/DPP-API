package parsers;

public class ByteParser extends AbstractParser<Byte> {

    ByteParser() {
        super("byte");
    }

    @Override
    public Byte parse(String argument) {
        this.argument = argument;
        return Byte.parseByte(argument);
    }
}
