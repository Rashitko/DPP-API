package DPPParser.parsers;

import DPPParser.arguments.ArgumentParser;

/**
 * Standard double parser
 */
public class DoubleArgumentParser implements ArgumentParser<Double> {

    private String argument;

    @Override
    public Double parse(String argument) throws ParsingException {
        this.argument = argument;
        try {
            return Double.parseDouble(argument);
        } catch (Exception ignore) {
            throw new ParsingException();
        }
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as double";
    }
}
