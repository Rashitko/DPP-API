package options;

public class ResolvedOption {

    private final Option underlyingOption;

    public ResolvedOption(Option underlyingOption) {
        this.underlyingOption = underlyingOption;
    }

    public String getArgAsString() {
        return (String) getObject();
    }

    public Object getObject() {
        return underlyingOption.getArgument().getValue();
    }

}
