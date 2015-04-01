package parsers;

/**
 * @param <T> Type specifying which type is used in the particular parser
 */
public abstract class AbstractParser<T> implements ArgumentParser<T> {

    private final String typeName;
    protected String argument;

    /**
     * Parser's constructor
     *
     * @param typeName string representation of type parameter T, which is used in parser's error message when parsing
     *                 cannot be successfully done
     */
    AbstractParser(String typeName) {
        //TODO
        this.typeName = typeName;
    }

    @Override
    public String getParseErrorMessage() {
        //TODO
        return null;
    }
}
