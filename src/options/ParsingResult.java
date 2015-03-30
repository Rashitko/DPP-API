package options;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class contains all related information about options after parsing is done
 */
public class ParsingResult {
    private final Set<Option> resolvedOptions;
    private final Set<String> regularArguments;
    private final List<Option> extraOptions;
    private final Set<Option> missingOptions;
    private final Set<Option> failedOptions;

    /**
     * Constructor
     */
    ParsingResult() {
        resolvedOptions = new HashSet<Option>();
        regularArguments = new HashSet<String>();
        extraOptions = new ArrayList<Option>();
        missingOptions = new HashSet<Option>();
        failedOptions = new HashSet<Option>();
    }

    /**
     * Adds option which has been entered on the input but it is not defined
     *
     * @param option option which has been entered on the input but it is not defined
     */
    void addExtraOption(Option option) {
        extraOptions.add(option);
    }

    /**
     * Adds option which is mandatory and is missing on the input
     * @param option option which is mandatory and is missing on the input
     */
    void addMissingOption(Option option) {
        missingOptions.add(option);
    }

    /**
     * Adds option which has been entered on the input but other conditions failed, such as
     *  it does not have argument when it should have one, the argument value does not fulfill given argument
     *  constraint or is of wrong type
     * @param option option which has been entered on the input but other conditions failed, such as
     *  it does not have argument when it should have one, the argument value does not fulfill given argument
     *  constraint or is of wrong type
     */
    void addFailedOption(Option option) {
        failedOptions.add(option);
    }

    /**
     * Checks if there are any extra options
     * @return true if there are any extra options, false otherwise
     */
    public boolean hasExtraOptions() {
        return extraOptions.size() > 0;
    }

    /**
     * Checks if there are any missing options
     * @return true if there are any missing options, false otherwise
     */
    public boolean hasMissingOptions() {
        return missingOptions.size() > 0;
    }

    /**
     * Checks if there are any failed options
     * @return true if there are any failed options, false otherwise
     */
    public boolean hasFailedOptions() {
        return failedOptions.size() > 0;
    }

    /**
     * Gets the list of extra options
     * @return the list of extra options
     */
    public List<Option> getExtraOptions() {
        return extraOptions;
    }

    /**
     * Gets the set of missing options
     * @return the set of missing options
     */
    public Set<Option> getMissingOptions() {
        return missingOptions;
    }

    /**
     * Gets list of failed options
     * @return list of failed options
     */
    public Set<Option> getFailedOptions() {
        return failedOptions;
    }

    /**
     * Gets the set of successfully resolved options
     * @return the set of successfully resolved options
     */
    public Set<Option> getResolvedOptions() {
        return resolvedOptions;
    }

    /**
     * Gets the set of regular arguments on the input
     * @return the set of regular arguments on the input
     */
    public Set<String> getRegularArguments() {
        return regularArguments;
    }

    /**
     * Gets the resolved option for one particular option
     * @param option option for which the resolved option is obtained
     * @return resolved option
     */
    public Option getResolvedOption(Option option) {
        //TODO: return desired option
        return null;
    }

    /**
     * Checks if there are any resolved options
     * @return true if there are any resolved options, false otherwise
     */
    public boolean hasAnyResolvedOptions() {
        //TODO: true if resolvedOptions is not empty
        return false;
    }

    /**
     * Chicks if there is the resolved option for one particular option
     * @param option option
     * @return true if there is the resolved option for particular option, otherwise false
     */
    public boolean hasResolvedOption(Option option) {
        //TODO: return if resolvedOptions contains option
        return false;
    }

    /**
     * Checks whether any errors occurred during parsing
     * @return true if any errors occurred during parsing, otherwise false
     */
    public boolean hasErrors() {
        //TODO: return whether errors occurred during parsing
        return true;
    }
}
