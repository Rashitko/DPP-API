package DPPParser.options;

import DPPParser.arguments.Argument;
import DPPParser.parsers.ParsingException;
import DPPParser.parsers.StringArgumentParser;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class main purpose is to parse the input and create ParsingResult object
 */
public class Parser {

    private final OptionsList optionsList;
    private final List<String> unmatchedArguments;
    private final List<String> regularArguments;

    /**
     * This constructor sets the set of options which are to be used during parsing
     *
     * @param optionsList the set of options which are to be used during parsing
     */
    public Parser(OptionsList optionsList) {
        this.optionsList = optionsList;
        unmatchedArguments = new ArrayList<String>();
        regularArguments = new ArrayList<String>();
    }

    /**
     * This method does the parsing and creates the object containing the resulting information
     *
     * @param arguments input argument to parse
     */
    public void resolveOptions(String[] arguments) {
        final ArrayList<String> args = new ArrayList<String>(Arrays.asList(arguments));
        while (!args.isEmpty()) {
            String switchString = args.remove(0);
            if (switchString.equals("--")) {
                break;
            }
            if (switchString.startsWith("-")) {
                Option option;
                final String optionName = getOptionName(switchString);
                final Option.Builder.SwitchType switchType;
                if (switchString.startsWith("--")) {
                    option = optionsList.findOptionByLongSwitch(optionName);
                    switchType = Option.Builder.SwitchType.LONG_SWITCH;
                } else {
                    option = optionsList.findOptionByShortSwitch(optionName);
                    switchType = Option.Builder.SwitchType.SHORT_SWITCH;
                }
                String argValue = null;
                if (!args.isEmpty() && !isArgOption(args.get(0))) {
                    argValue = args.remove(0);
                }
                processOption(option, optionName, switchType, argValue);
            } else {
                unmatchedArguments.add(switchString);
            }
        }
        regularArguments.addAll(args);
        checkMissedOptions();
    }

    /**
     * Checks if all mandatory options are set,
     * for mandatory options which are not set the flag
     * {@link DPPParser.options.Option.ParseResult#OPTION_MISSED} is set
     */
    private void checkMissedOptions() {
        for (Option option : optionsList) {
            if (option.isMandatory() && option.getArgument().getValue() == null) {
                option.setParseResult(Option.ParseResult.OPTION_MISSED);
            }
        }
    }

    /**
     * Process given {@link Option}. This method sets options value if possible.
     * If {@link Option} is null, that means the option is not provided in the {@link OptionsList}
     * and will be created as an extra {@link Option}.
     *
     * @param option     option which should be processed, can be null
     * @param optionName string representation of one of the {@link Option}'s switches (either short or long)
     * @param switchType switch type by which can be the {@link Option} found
     * @param value      string representation of {@link Option}'s argument value, can be null if no argument was provided
     */
    private void processOption(@Nullable Option option, String optionName, Option.Builder.SwitchType switchType, @Nullable String value) {
        if (option == null) {
            createExtraOption(optionName, switchType, value);
            return;
        }
        Option.ParseResult optionParseResult = Option.ParseResult.SUCCESS;
        if (option.hasMandatoryArgument() && value == null) {
            optionParseResult = Option.ParseResult.ARGUMENT_MISSED;
        } else if (option.hasArgument() && value != null) {
            optionParseResult = setOptionArgValue(option, value, optionParseResult);
        }
        option.setParseResult(optionParseResult);
    }

    /**
     * Sets {@link Option}'s argument value.
     * If parsing failed, then the result will be {@link Option.ParseResult#PARSING_FAILED},
     * otherwise provided optionParseResult will be returned unchanged.
     *
     * @param option            {@link Option} which should be processed
     * @param value             string representation of value, which should be set
     * @param optionParseResult {@link DPPParser.options.Option.ParseResult} which should be returned if parsing will be successful
     * @return optionParseResult or {@link Option.ParseResult#PARSING_FAILED} if parsing failed
     */
    private Option.ParseResult setOptionArgValue(Option option, String value, Option.ParseResult optionParseResult) {
        try {
            final Argument argument = option.getArgument();
            Object parsedArgValue = argument.getArgumentParser().parse(value);
            //noinspection unchecked
            argument.setValue(parsedArgValue);
            if (argument.hasConstraint()) {
                //noinspection unchecked
                final boolean constraintFulfilled = argument.getConstraint().isFulfilled(parsedArgValue);
                if (!constraintFulfilled) {
                    optionParseResult = Option.ParseResult.CONSTRAINT_FAILED;
                }
            }
        } catch (ParsingException ignore) {
            optionParseResult = Option.ParseResult.PARSING_FAILED;
        }
        return optionParseResult;
    }

    /**
     * Creates an {@link Option} with the {@link DPPParser.options.Option.ParseResult#EXTRA} flag set.
     *
     * @param optionName string representation of {@link Option}'s switch (either short or long)
     * @param switchType type of switch by which can be the {@link Option} found
     * @param value      value of {@link Option}'s argument, can be null if no argument was provided
     */
    private void createExtraOption(String optionName, Option.Builder.SwitchType switchType, String value) {
        Option.Builder builder = new Option.Builder(optionName, switchType);
        if (value != null) {
            builder.setOptionalArgument(new Argument<String>(new StringArgumentParser()));
        }
        Option option = builder.build();
        if (option.hasArgument() && value != null) {
            //noinspection unchecked
            option.getArgument().setValue(value);
            option.setParseResult(Option.ParseResult.EXTRA);
        }
        optionsList.add(option);
    }

    /**
     * @param arg
     * @return true if arg doesn't represent option or regular arguments delimiter
     */
    private boolean isArgOption(String arg) {
        return arg.startsWith("-") && !arg.equals("--");
    }

    /**
     * Removes dashes in the beginning of option.
     * If provided string does not contain '-' or "--" in the beginning, nothing is changed.
     *
     * @param arg provided string representing the {@link Option}
     * @return string with removed leading '-' or "--"
     */
    private String getOptionName(String arg) {
        if (arg.startsWith("--")) {
            return arg.replaceFirst("--", "");
        }
        if (arg.startsWith("-")) {
            return arg.replaceFirst("-", "");
        }
        return arg;
    }

    /**
     * @return list of failed options
     */
    public List<Option> getFailedOptions() {
        List<Option> result = new ArrayList<Option>();
        for (Option option : optionsList) {
            if (option.isFailed()) {
                result.add(option);
            }
        }
        return result;
    }

    /**
     * @return list of extra options
     */
    public List<Option> getExtraOptions() {
        List<Option> result = new ArrayList<Option>();
        for (Option option : optionsList) {
            if (option.isExtra()) {
                result.add(option);
            }
        }
        return result;
    }

    /**
     * @return list of missed options
     */
    public List<Option> getMissedOptions() {
        List<Option> result = new ArrayList<Option>();
        for (Option option : optionsList) {
            if (option.isMissed()) {
                result.add(option);
            }
        }
        return result;
    }

    /**
     * @return true if at least one option is failed
     */
    public boolean hasError() {
        return getFailedOptions().size() > 0;
    }

    /**
     * @return list of argument, which cannot be matched to any option.
     * For example if command line arguments will be "-s 123 456 --long-option", then
     * the "456" will be unmatched argument
     */
    public List<String> getUnmatchedArguments() {
        return unmatchedArguments;
    }

    /**
     * @return list of arguments after "--" delimiter
     */
    public List<String> getRegularArguments() {
        return regularArguments;
    }
}
