package options;

import java.util.Set;

public class ArgumentMatcher {
    private Set<ResolvedOption> resolvedOptions;
    private Set<String> regularArguments;

    public Set<String> getRegularArguments() {
        return regularArguments;
    }

    public Set<ResolvedOption> getResolvedOptions() {
        return resolvedOptions;
    }

    public boolean hasResolvedOptions() {
        //TODO: true if resolvedOptions is not empty
        return false;
    }

    public boolean hasResolvedOption(Option option) {
        //TODO: return if resolvedOptions contains option
        return false;
    }

    public ResolvedOption getResolvedOption(Option option) {
        //TODO: return desired option
        return null;
    }
}
