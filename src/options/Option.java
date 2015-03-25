package options;

import java.util.List;

abstract class Option {

    private final String shortOption;
    private final List<String> longOptions;
    private final boolean isOptional;

}
