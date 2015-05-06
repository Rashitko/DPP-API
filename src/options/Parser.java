package options;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This class main purpose is to parse the input and create ParsingResult object
 */
public class Parser {

    private final Set<Option> optionsSet;

    /**
     * This constructor sets the set of options which are to be used during parsing
     *
     * @param optionsSet the set of options which are to be used during parsing
     */
    public Parser(Set<Option> optionsSet) {
        this.optionsSet = optionsSet;
    }

    /**
     * This method does the parsing and creates the object containing the resulting information
     *
     * @param arguments input argument to parse
     * @return ParsingResult object containing the resulting information
     */
    public void resolveOptions(String[] arguments) {
        //TODO: Fill-in argument values and return modified optionsDefinition

        final List<String> strings = arrayToArrayList(arguments);
        while (!strings.isEmpty()) {
            String arg = strings.remove(0);
            if (arg.equals("--")) {
                break;
            }
            if (arg.startsWith("--")) {
                Option option = findOptionByLongSwitch(getOptionName(arg));
                String value = null;
                if (!strings.isEmpty() && !isOption(strings.get(0))) {
                    value = strings.remove(0);
                }
                processOption(option, arg, value);
            } else if (arg.startsWith("-")) {
                System.out.printf("short option: %s\n", getOptionName(arg));
            }
        }
    }

    private void processOption(@Nullable Option option, String arg, String value) {
        System.out.printf("long option: %s\n", getOptionName(arg));
        Object argValue = null;
        final boolean optionHasArgument = option != null && option.getArgument() != null;
        if (optionHasArgument && value != null) {
            argValue = option.getArgument().getParser().parse(value);
        }
        Option.ParseResult optionParseResult = Option.ParseResult.SUCCESS;
        if (option == null) {
            option = new Option.Builder(arg, Option.Builder.SwitchType.LONG_SWITCH).build();
            optionParseResult = Option.ParseResult.EXTRA;
        } else if (option.hasMandadoryArgument() && option.getArgument().getValue() == null) {
            optionParseResult = Option.ParseResult.ARGUMENT_MISSED;
        } else if (option.hasArgument() && option.getArgument().getParser().getParseErrorMessage() != null) {
            optionParseResult = Option.ParseResult.PARSING_FAILED;
        }
        option.setParseResult(optionParseResult);
    }

    private boolean isOption(String arg) {
        return !arg.equals("--") && !(arg.startsWith("--") || arg.startsWith("-"));
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

    private ArrayList<String> arrayToArrayList(String[] strings) {
        ArrayList<String> result = new ArrayList<String>(strings.length);
        for (String element : strings) {
            result.add(element);
        }
        return result;
    }

    public List<Option> getFailedOptions() {
        //TODO
        return null;
    }

    public List<Option> getExtraOptions() {
        //TODO
        return null;
    }

    public boolean hasError() {
        return getFailedOptions().size() > 0;
    }
}
