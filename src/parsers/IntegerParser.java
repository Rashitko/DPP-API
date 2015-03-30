package parsers;

public class IntegerParser implements ArgumentParser<Integer> {

    @Override
    public Integer parse(String argument) {
        return Integer.parseInt(argument);
    }

    @Override
    public String getError(String argument) {
        return null;
    }
}
