package parsers;

public abstract class AbstractParser<T> implements ArgumentParser<T> {

    private final String typeName;
    protected String argument;

    AbstractParser(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String getParseErrorMessage() {
        return argument + " cannot be parsed as " + typeName;
    }
}
