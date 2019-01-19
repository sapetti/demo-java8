import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class DemoFunctionalInterfaces {

    static Predicate<Integer> isEven = num -> {
        print("isEven::" + num);
        return num % 2 == 0;
    };

    static Consumer<String> say = text -> {
        print("say::");
        print(text);
    };

    static Supplier<Integer> getValue = () -> {
        print("getValue::");
        return 1234;
    };

    static Function<Integer, String> numberAsEuro = num -> {
        print("numberAsEuro::");
        return num + "€";
    };

    static BiFunction<Integer, String, String> numberAs = (num, currency) -> {
        print("numberAs::");
        return num + currency;
    };

    static UnaryOperator<List<String>> addValueToList = list -> {
        list.add("Value");
        return list;
    };

    static BinaryOperator<List<String>> migrateList = (list1, list2) -> {
        list2.addAll(list1);
        return list2;
    };

    public static void main(String[] args) {
        print("Predicate ============>");
        print(isEven.test(1));
        print(isEven.test(2));
        print("");

        print("Consumer ============>");
        say.accept("Hello Consumer");
        print("");

        print("Supplier ============>");
        print(getValue.get());
        print("");

        print("Function ============>");
        print(numberAsEuro.apply(10));
        print("");

        print("BiFunction ============>");
        print(numberAs.apply(10, "$"));
        print("");

        print("UnaryOperator ============>");
        List<String> list1 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        print(addValueToList.apply(list1));
        print("");

        print("BinaryOperator ============>");
        List<String> list2 = new ArrayList<>(Arrays.asList("3", "4", "5"));
        print(migrateList.apply(list1, list2));
        print("");

        print("AndThen ============>"); // compose
        print(numberAsEuro.andThen(s -> s + " Sale")
                          .andThen(s -> s + "!!!")
                          .apply(100));
        print("");
    }

    static void print(Object text) {
        System.out.println(text);
    }
}
