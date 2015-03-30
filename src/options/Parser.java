package options;

import java.util.Set;

/**
 * This class main purpose is to parse the input and create ParsingResult object
 */
public class Parser {

    private final Set<Option> optionsSet;

    /**
     * This constructor sets the set of options which are to be used during parsing
     *
     * @param optionsSet the set of options which are to be used during parsing
     */
    public Parser(Set<Option> optionsSet) {
        this.optionsSet = optionsSet;
    }

    /**
     * This method does the parsing and creates the object containing the resulting information
     * @param arguments input argument to parse
     * @return ParsingResult object containing the resulting information
     */
    public ParsingResult resolveOptions(String[] arguments) {
        //TODO: Fill-in argument values and return modified optionsDefinition
        return null;
    }
}
