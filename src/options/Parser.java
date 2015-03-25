package options;

public class Parser {

    private OptionsDefinition optionsDefinition;

    public Parser(OptionsDefinition optionsDefinition) {
        this.optionsDefinition = optionsDefinition;
    }

    public ArgumentMatcher resolveOptions(String[] arguments) {
        return false;
    }

}
