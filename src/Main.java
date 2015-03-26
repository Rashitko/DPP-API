import arguments.Argument;
import options.*;

public class Main {

    public static int main(String[] args) {
        OptionsDefinition optDef = new OptionsDefinition();
        Argument<Integer> integerArgument = new Argument<Integer>();

        OptionWithArgument option1 = new OptionWithArgument(integerArgument, OptionWithArgument.ArgumentPresence.MANDATORY);

        optDef.addOption(option1);
        optDef.addOption(option2);
        optDef.addOption(option3);
        optDef.addOption(option4);
        optDef.addOption(option5);
        Parser parser = new Parser(optDef);
        ArgumentMatcher argumentMatcher = parser.resolveOptions(args);
        ResolvedOption resolvedOption = argumentMatcher.getResolvedOption(option1);
        resolvedOption.
        System.out.println("Hello");
    }

}
