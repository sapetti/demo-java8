import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

public class DemoOptional {

    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        empty.ifPresentOrElse(s -> print("Value::" + s),
                () -> print("Is empty"));

        Optional<String> nullable = Optional.ofNullable(null);
        nullable.ifPresentOrElse(s -> print("Value::" + s),
                () -> print("Nullable Is empty"));
        // Null?
//        Optional<String> nullOption = Optional.of(null);

        Optional.ofNullable(getRamdomNumber())
                .map(n -> n + 2)
                .filter(n -> n > 6);

    }

    static int getRamdomNumber() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

    static void print(Object text) {
        System.out.println(text);
    }
}
