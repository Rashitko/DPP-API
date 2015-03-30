package parsers;

/**
 * @param <E> Type specifying which type is used in the particular parser
 */
public interface ArgumentParser<E> {

    /**
     * Tries to parse string in argument as type E
     *
     * @param argument argument to parse
     * @return parsed argument
     */
    public E parse(String argument);

    /**
     * Gets the error message for the situation when parsing is not successful
     * @return the error message for the situation when parsing is not successful
     */
    public String getParseErrorMessage();

}
