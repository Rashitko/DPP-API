package options;

import arguments.ArgumentValue;

import java.util.HashMap;
import java.util.List;


public class ArgumentMatcher {
    private HashMap<Option, ArgumentValue>;
    private List<String> regularArguments;

    public List<String> getRegularArguments() {
        return regularArguments;
    }
}
