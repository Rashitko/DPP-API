package parsers;

public class IntegerParser implements ArgumentParser<Integer> {

    private String argument;

    @Override
    public Integer parse(String argument) {
        this.argument = argument;
        return Integer.parseInt(argument);
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as Integer";
    }
}
