package parsers;

public class ByteParser implements ArgumentParser<Byte> {

    @Override
    public Byte parse(String argument) {
        return Byte.parseByte(argument);
    }
}
