package arguments;


import java.util.List;

public class Argument<E> {

    private List<ArgumentConstraint<E>> constraints;
    private ArgumentParser<E> parser;
    private E value;

}
