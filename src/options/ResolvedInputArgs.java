package options;

import java.util.Set;

public class ResolvedInputArgs {
    private Set<Option> resolvedOptions;
    private Set<String> regularArguments;

    public Set<Option> getResolvedOptions() {
        return resolvedOptions;
    }

    public Set<String> getRegularArguments() {
        return regularArguments;
    }

    public Option getResolvedOption(Option option) {
        //TODO: return desired option
        return null;
    }

    public boolean hasAnyResolvedOptions() {
        //TODO: true if resolvedOptions is not empty
        return false;
    }

    public boolean hasResolvedOption(Option option) {
        //TODO: return if resolvedOptions contains option
        return false;
    }
}
