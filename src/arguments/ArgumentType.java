package arguments;

import java.util.List;

public class ArgumentType<E> {

    private List<ArgumentConstraint<E>> constraints;
    private ArgumentParser<E> parser;

}
