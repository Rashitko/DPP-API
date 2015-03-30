package parsers;

public class DoubleParser implements ArgumentParser<Double> {

    @Override
    public Double parse(String argument) {
        return Double.parseDouble(argument);
    }
}
