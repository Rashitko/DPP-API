package parsers;

import arguments.ArgumentParser;

public class BooleanParser implements ArgumentParser<Boolean> {

    @Override
    public Boolean parse(String argument) {
        return Boolean.parseBoolean(argument);
    }
}
