package arguments;

import parsers.ParsingException;

/**
 * @param <E> Type of argument the parser is applied on
 */
public interface ArgumentParser<E> {

    /**
     * Parse string in the parameter as argument of type E
     *
     * @param argument argument to parse
     * @return parsed argument
     */
    public E parse(String argument) throws ParsingException;

    /**
     * Get the error message when parsing is not successful
     *
     * @return the error message when parsing is not successful
     */
    public String getParseErrorMessage();

}
