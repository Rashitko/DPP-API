package DPPParser.options;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OptionsList implements Iterable<Option> {

    private final List<Option> options;

    public OptionsList() {
        options = new ArrayList<Option>();
    }

    /**
     * Gets the number of options in the option list
     *
     * @return number of options in the option list
     */
    public int getSize() {
        return options.size();
    }

    /**
     * Adds {@link Option} to the OptinsList if no option in list can be found
     * by any of the long or short switched of provided {@link Option}.
     * If an {@link Option} can be found, then false is returned and list is unchanged.
     *
     * @param option {@link Option} to be added
     * @return true if {@link OptionsList} does not contain provided option
     */
    public boolean add(Option option) {
        final Set<String> shortSwitches = option.getShortSwitches();
        final Set<String> longSwitches = option.getLongSwitches();
        for (String shortSwitch : shortSwitches) {
            if (findOptionByShortSwitch(shortSwitch) != null) {
                return false;
            }
        }
        for (String longSwitch : longSwitches) {
            if (findOptionByLongSwitch(longSwitch) != null) {
                return false;
            }
        }
        options.add(option);
        return true;
    }

    /**
     * Returns {@link Option} which has provided long switch, or null if such {@link Option} does not exist.
     *
     * @param longSwitch long switch which should be contained in returned {@link Option}
     * @return {@link Option} with wanted long switch
     */
    @Nullable
    public Option findOptionByLongSwitch(String longSwitch) {
        for (Option option : options) {
            if (option.hasLongSwitch(longSwitch)) {
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
    public Option findOptionByShortSwitch(String shortSwitch) {
        for (Option option : options) {
            if (option.hasShortSwitch(shortSwitch)) {
                return option;
            }
        }
        return null;
    }

    @Override
    public Iterator<Option> iterator() {
        return new OptionsIterator();
    }

    private class OptionsIterator implements Iterator<Option> {

        private int index;

        private OptionsIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < options.size();
        }

        @Override
        public void remove() {
            options.remove(index);
        }

        @Override
        public Option next() {
            final Option result = options.get(index);
            index++;
            return result;
        }
    }

}
