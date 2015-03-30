package options;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParsingResult {
    private final Set<Option> resolvedOptions;
    private final Set<String> regularArguments;
    private final List<Option> extraOptions;
    private final Set<Option> missingOptions;
    private final Set<Option> failedOptions;

    ParsingResult() {
        resolvedOptions = new HashSet<Option>();
        regularArguments = new HashSet<String>();
        extraOptions = new ArrayList<Option>();
        missingOptions = new HashSet<Option>();
        failedOptions = new HashSet<Option>();
    }

    void addExtraOption(Option option) {
        extraOptions.add(option);
    }

    void addMissingOption(Option option) {
        missingOptions.add(option);
    }

    void addFailedOption(Option option) {
        failedOptions.add(option);
    }

    public boolean hasExtraOptions() {
        return extraOptions.size() > 0;
    }

    public boolean hasMissingOptions() {
        return missingOptions.size() > 0;
    }

    public boolean hasFailedOptions() {
        return failedOptions.size() > 0;
    }

    public List<Option> getExtraOptions() {
        return extraOptions;
    }

    public Set<Option> getMissingOptions() {
        return missingOptions;
    }

    public Set<Option> getFailedOptions() {
        return failedOptions;
    }

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

    public boolean hasErrors() {
        //TODO: return whether errors occured during parsing
        return true;
    }
}
