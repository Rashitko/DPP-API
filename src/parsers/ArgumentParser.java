package parsers;

public interface ArgumentParser<E> {

    public E parse(String argument);

    public String getParseErrorMessage();

}
