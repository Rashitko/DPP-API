package parsers;

import arguments.ArgumentParser;

public class FloatParser implements ArgumentParser<Float> {

    @Override
    public Float parse(String argument) {
        return Float.parseFloat(argument);
    }
}