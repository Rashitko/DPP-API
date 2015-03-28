package parsers;

import arguments.ArgumentParser;

public class DoubleParser implements ArgumentParser<Double> {

    @Override
    public Double parse(String argument) {
        return Double.parseDouble(argument);
    }
}
