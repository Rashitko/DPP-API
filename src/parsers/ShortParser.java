package parsers;

import arguments.ArgumentParser;

public class ShortParser implements ArgumentParser<Short> {

    @Override
    public Short parse(String argument) {
        return Short.parseShort(argument);
    }
}
