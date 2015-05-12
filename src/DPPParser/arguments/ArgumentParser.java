package DPPParser.arguments;

import DPPParser.parsers.ParsingException;

/**
 * @param <E> Type of argument the parser is applied on
 */
public interface ArgumentParser<E> {

    /**
     * Parse string in the parameter as argument of type E.
     * Note that if any Exception is thrown during parsing,
     * this Exception is caught by default Parsers
     * and {@link DPPParser.parsers.ParsingException} is thrown instead.
     * This exception is handled in the library and results in returning
     * {@link DPPParser.options.Option.ParseResult#PARSING_FAILED} in {@link DPPParser.options.Option#getParseResult()}.
     * All subclasses should follow this pattern.
     *
     * @param argument argument to parse
     * @return parsed argument
     * @throws ParsingException parsing exception
     */
    E parse(String argument) throws ParsingException;

    /**
     * Get the error message when parsing is not successful
     *
     * @return the error message when parsing is not successful
     */
    String getParseErrorMessage();

}
