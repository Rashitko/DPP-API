package parsers;

public class IntegerParser implements ArgumentParser<Integer> {

    @Override
    public Integer parse(String argument) {
        return Integer.parseInt(argument);
    }
}
