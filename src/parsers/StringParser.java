package parsers;

public class StringParser implements ArgumentParser<String> {

    @Override
    public String parse(String argument) {
        return argument;
    }
}
