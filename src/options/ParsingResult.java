package options;

import com.sun.istack.internal.Nullable;

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

    }

    /**
     * Adds option which is mandatory and is missing on the input
     *
     * @param option option which is mandatory and is missing on the input
     */
    void addMissingOption(Option option) {

    }

    /**
     * Adds option which has been entered on the input but other conditions failed, such as
     * it does not have argument when it should have one, the argument value does not fulfill given argument
     * constraint or is of wrong type
     *
     * @param option option which has been entered on the input but other conditions failed, such as
     *               it does not have argument when it should have one, the argument value does not fulfill given argument
     *               constraint or is of wrong type
     */
    void addFailedOption(Option option) {
        //TODO
    }

    /**
     * Checks if there are any resolved options
     *
     * @return true if there are any resolved options, false otherwise
     */
    public boolean hasAnyResolvedOptions() {
        //TODO: true if resolvedOptions is not empty
        return false;
    }

    /**
     * Checks if there are any extra options
     *
     * @return true if there are any extra options, false otherwise
     */
    public boolean hasExtraOptions() {
        //TODO
        return false;
    }

    /**
     * Checks if there are any missing options
     *
     * @return true if there are any missing options, false otherwise
     */
    public boolean hasMissingOptions() {
        //TODO
        return false;
    }

    /**
     * Checks if there are any failed options
     *
     * @return true if there are any failed options, false otherwise
     */
    public boolean hasFailedOptions() {
        //TODO
        return false;
    }

    /**
     * Gets the set of successfully resolved options
     *
     * @return the set of successfully resolved options
     */
    public Set<Option> getResolvedOptions() {
        //TODO
        return null;
    }

    /**
     * Gets the set of regular arguments on the input
     *
     * @return the set of regular arguments on the input
     */
    public Set<String> getRegularArguments() {
        //TODO
        return null;
    }

    /**
     * Gets the list of extra options
     *
     * @return the list of extra options
     */
    public List<Option> getExtraOptions() {
        //TODO
        return null;
    }

    /**
     * Gets the set of missing options
     *
     * @return the set of missing options
     */
    public Set<Option> getMissingOptions() {
        //TODO
        return null;
    }

    /**
     * Gets list of failed options
     *
     * @return list of failed options
     */
    public Set<Option> getFailedOptions() {
        //TODO
        return null;
    }

    /**
     * Gets the resolved option for one particular option
     *
     * @param option option for which the resolved option is obtained
     * @return resolved option, null if option is not found
     */
    @Nullable
    public Option getResolvedOption(Option option) {
        //TODO: return desired option
        return null;
    }

    /**
     * Gets the missing option for one particular option
     *
     * @param option option for which the missing option is obtained
     * @return resolved option, null if option is not found
     */
    @Nullable
    public Option getMissingOption(Option option) {
        //TODO: return desired option
        return null;
    }

    /**
     * Gets the failed option for one particular option
     *
     * @param option option for which the failed option is obtained
     * @return failed option, null if option is not found
     */
    @Nullable
    public Option getFailedOption(Option option) {
        //TODO: return desired option
        return null;
    }

    /**
     * Gets the resolved option which has provided switch
     * set either as short or long switch
     *
     * @param switchString provided switch
     * @return Option with switch, or null if no such Option is found
     */
    @Nullable
    public Option getResolvedOption(String switchString) {
        //TODO: return desired option which has corresponding switch
        return null;
    }

    /**
     * Gets the missing option which has provided switch
     * set either as short or long switch
     *
     * @param switchString provided switch
     * @return Option with switch, or null if no such Option is found
     */
    @Nullable
    public Option getMissingOption(String switchString) {
        //TODO: return desired option which has corresponding switch
        return null;
    }

    /**
     * Gets the failed option which has provided switch
     * set either as short or long switch
     *
     * @param switchString provided switch
     * @return Option with switch, or null if no such Option is found
     */
    @Nullable
    public Option getFailedOption(String switchString) {
        //TODO: return desired option which has corresponding switch
        return null;
    }

    /**
     * Checks if there is the resolved option for one particular option
     *
     * @param option option
     * @return true if there is the resolved option for particular option, otherwise false
     */
    public boolean isResolvedOption(Option option) {
        //TODO: return if resolvedOptions contains option
        return false;
    }

    /**
     * Checks if there is the missing option for one particular option
     *
     * @param option option
     * @return true if there is the missing option for particular option, otherwise false
     */
    public boolean isMissingOption(Option option) {
        //TODO: return if resolvedOptions contains option
        return false;
    }

    /**
     * Checks if there is the failed option for one particular option
     *
     * @param option option
     * @return true if there is the failed option for particular option, otherwise false
     */
    public boolean isFailedOption(Option option) {
        //TODO: return if resolvedOptions contains option
        return false;
    }

    /**
     * Checks whether any errors occurred during parsing
     *
     * @return true if any errors occurred during parsing, otherwise false
     */
    public boolean anyErrorHappened() {
        //TODO: return whether errors occurred during parsing
        return true;
    }
}
