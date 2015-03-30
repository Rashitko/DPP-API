package parsers;

public class LongParser implements ArgumentParser<Long> {

    @Override
    public Long parse(String argument) {
        return Long.parseLong(argument);
    }
}
