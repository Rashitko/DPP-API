package options;

import java.util.List;


public class ArgumentMatcher {
    private List<ResolvedOption> resolvedOptions;
    private List<String> regularArguments;

    public List<String> getRegularArguments() {
        return regularArguments;
    }

    public List<ResolvedOption> getResolvedOptions() {
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
