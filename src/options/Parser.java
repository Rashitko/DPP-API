package options;

import com.sun.istack.internal.Nullable;
import parsers.ParsingException;
import parsers.StringParser;

import java.util.*;

/**
 * This class main purpose is to parse the input and create ParsingResult object
 */
public class Parser {

    private final Set<Option> optionsSet;
    private final List<String> unmatchedArguments;
    private final List<String> regularArguments;

    /**
     * This constructor sets the set of options which are to be used during parsing
     *
     * @param optionsSet the set of options which are to be used during parsing
     */
    public Parser(Set<Option> optionsSet) {
        this.optionsSet = optionsSet;
        unmatchedArguments = new ArrayList<String>();
        regularArguments = new ArrayList<String>();
    }

    /**
     * This method does the parsing and creates the object containing the resulting information
     *
     * @param arguments input argument to parse
     * @return ParsingResult object containing the resulting information
     */
    public void resolveOptions(String[] arguments) {
        final ArrayList<String> args = new ArrayList<String>(Arrays.asList(arguments));
        while (!args.isEmpty()) {
            String arg = args.remove(0);
            if (arg.equals("--")) {
                break;
            }
            if (arg.startsWith("-")) {
                Option option;
                if (arg.startsWith("--")) {
                    option = findOptionByLongSwitch(getOptionName(arg));
                } else {
                    option = findOptionByShortSwitch(getOptionName(arg));
                }
                String argValue = null;
                if (!nextIsOption(args)) {
                    argValue = args.remove(0);
                }
                processOption(option, arg, argValue);
            } else {
                unmatchedArguments.add(arg);
            }
        }
        regularArguments.addAll(args);
        checkMissedOptions();
    }

    private void checkMissedOptions() {
        for (Option option : optionsSet) {
            if (option.isMandatory() && option.getArgument().getValue() == null) {
                option.setParseResult(Option.ParseResult.OPTION_MISSED);
            }
        }
    }

    private void processOption(@Nullable Option option, String arg, @Nullable String value) {
        if (option == null) {
            processExtraOption(arg, Option.Builder.SwitchType.LONG_SWITCH, value);
            return;
        }
        Option.ParseResult optionParseResult = Option.ParseResult.SUCCESS;
        if (option.hasMandadoryArgument() && value == null) {
            optionParseResult = Option.ParseResult.ARGUMENT_MISSED;
        } else if (option.hasArgument() && value != null) {
            try {
                Object parsedArgValue = option.getArgument().getParser().parse(value);
                //noinspection unchecked
                option.getArgument().setValue(parsedArgValue);
            } catch (ParsingException ignore) {
                optionParseResult = Option.ParseResult.PARSING_FAILED;
            }
        }
        option.setParseResult(optionParseResult);
    }

    private void processExtraOption(String switchString, Option.Builder.SwitchType switchType, String value) {
        Option.Builder builder = new Option.Builder(switchString, switchType);
        if (value != null) {
            builder.setOptionalArgument(new Argument.Builder<String>(new StringParser()).build());
        }
        Option option = builder.build();
        if (option.hasArgument()) {
            //noinspection unchecked
            option.getArgument().setValue(value);
            option.setParseResult(Option.ParseResult.EXTRA);
        }
        optionsSet.add(option);
    }

    private boolean nextIsOption(ArrayList<String> args) {
        if (args.size() > 0) {
            String arg = args.get(0);
            return arg.startsWith("-") && !arg.equals("--");
        }
        return false;
    }

    /**
     * Returns {@link Option} which has provided long switch, or null if such {@link Option} does not exist.
     *
     * @param longSwitch long switch which should be contained in returned {@link Option}
     * @return {@link Option} with wanted long switch
     */
    @Nullable
    private Option findOptionByLongSwitch(String longSwitch) {
        for (Option option : optionsSet) {
            if (option.getLongSwitches().contains(longSwitch)) {
                return option;
            }
        }
        return null;
    }

    /**
     * Returns {@link Option} which has provided short switch, or null if such {@link Option} does not exist.
     *
     * @param shortSwitch short switch which should be contained in returned {@link Option}
     * @return {@link Option} with wanted short switch
     */
    @Nullable
    private Option findOptionByShortSwitch(String shortSwitch) {
        for (Option option : optionsSet) {
            if (option.getShortSwitches().contains(shortSwitch)) {
                return option;
            }
        }
        return null;
    }

    /**
     * Removes dashes in the beginning of option.
     * If provided string does not contain '-' or "--" in the beginning, nothing is changed.
     *
     * @param arg provided string representing the {@link options.Option}
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

    public List<Option> getFailedOptions() {
        List<Option> result = new ArrayList<Option>();
        for (Option option : optionsSet) {
            if (option.isFailed()) {
                result.add(option);
            }
        }
        return result;
    }

    public List<Option> getExtraOptions() {
        List<Option> result = new ArrayList<Option>();
        for (Option option : optionsSet) {
            if (option.isExtra()) {
                result.add(option);
            }
        }
        return result;
    }

    public List<Option> getMissedOptions() {
        List<Option> result = new ArrayList<Option>();
        for (Option option : optionsSet) {
            if (option.isMissed()) {
                result.add(option);
            }
        }
        return result;
    }

    public boolean hasError() {
        return getFailedOptions().size() > 0;
    }

    public List<String> getUnmatchedArguments() {
        return unmatchedArguments;
    }

    public List<String> getRegularArguments() {
        return regularArguments;
    }
}
