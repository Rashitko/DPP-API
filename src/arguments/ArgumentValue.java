package arguments;

/**
 * Created by aku on 25.3.15.
 */
public class ArgumentValue<E>{

    private final E value;

    public ArgumentValue(E value) {
        this.value = value;
    }

    public E getValue(){
        return value;
    }
}
