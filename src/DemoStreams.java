import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoStreams {

    //private static final Logger LOG = LoggerFactory.getLogger(DemoStreams.class);


    // Stream API
    // Streams are one of the most important APIs introduced in Java 8 and
    // completely changes the way we do processing of Collections in Java.
    // This is in line with the theme of Java since past few versions
    // where advances in hardware got exploited by the language.

    public static void main(String[] args) {

        IntStream.range(0, 5)
                .mapToObj(String::valueOf)
                .forEach(System.out::println);


//        long total = IntStream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//                .filter(x -> x % 2 == 0)
//                .map(x -> x + 10)
//                .peek(printVal)
//                .reduce(0, (acc, curr) -> acc + curr);
////                .sum();
////                .count(); // Numero de items
//        LOG.debug("Total::" + total);


//        IntStream.of(0, 0, 2, 2, 4, 4, 6, 6, 8, 8, 10)
//                .distinct() //
//                .skip(2)  // Skip 2 primeros
////                .limit(2) // Solos los 2 primeros
//                .forEach(printVal);


//        boolean isFalse = Stream.of("uno", "dos", "tres")
//        .allMatch(s -> s.length() > 3);
//        LOG.debug("" + isFalse);
//        boolean isTrue = Stream.of("uno", "dos", "tres")
//                .allMatch(s -> s.length() <= 4);
//        LOG.debug("" + isTrue);


//        List<User> users = Arrays.asList("Miguel", "Gabriel", "Raul", "Cesar")
//                .stream()
//                .map(n -> new User(n))
////                .map(User::new)
//                .collect(Collectors.toList()); // Collectors!
//        System.out.println(users.toString());


        //Collectors: toList, toSet, toCollection(LinkedList::new), toMap...
//        List<String> names = Arrays.asList("Miguel", "Gabriel", "Raul", "Cesar");
//        System.out.println(names
//                .stream()
//                .collect(Collectors.toMap(String::length, n -> n))); // Function.identity()
        //----> Key collision
//        List<String> names = Arrays.asList("Jose", "Miguel", "Gabriel", "Raul", "Cesar");
//        System.out.println(names
//                .stream()
//                .collect(Collectors.toMap(String::length,
//                                          Function.identity(),
//                                          (v1, v2) -> v1)));
        //
//        List<String> names = Arrays.asList("Miguel", "Gabriel", "Raul", "Cesar");
//        System.out.println(names.stream().collect(Collectors.joining()));
//        System.out.println(names.stream().collect(Collectors.joining(",")));
//        System.out.println(names.stream().collect(Collectors.counting()));
//        System.out.println(names.stream().collect(Collectors.averagingInt(String::length)));
//        System.out.println(names.stream().collect(
//                                            Collectors.maxBy( //minBy
//                                                    Comparator.naturalOrder()))); //reverseOrder
//        System.out.println(names.stream().collect(Collectors...));


//        List<Developer> developers = Arrays.asList(
//                new Developer("Carlos",  "C#",     7, "carlos@mail.com"),
//                new Developer("Julia",   "Kotlin", 3, "Julia@mail.com"),
//                new Developer("Roberto", "Java",   2, "Roberto@mail.com"),
//                new Developer("Raquel",  "Scala",  6, "Raquel@mail.com"),
//                new Developer("Jose",    "Java",   5, "Jose@mail.com"),
//                new Developer("Marta",   "Java",   8, "Marta@mail.com"),
//                new Developer("Irene",   "Java",   17, "Irene@mail.com"),
//                new Developer("Juan",    "Java",   6, "Juan@mail.com")
//                );
//
//        System.out.println(
//                developers.stream()
//                .filter(d -> "Java".equals(d.getLanguage())) // knowsJava
//                .filter(d -> d.getExperience() > 5)                          // moreThan5Years
//                .map(d -> d.getMail())
//                .findFirst()
//                .orElse("Not found"));

//        IntStream.range(0, 100)
////                .parallel() // .stream() vs .parallelStream()
//                .forEach(printVal);

    }

    private static IntConsumer printVal = System.out::println;

    private static class User {
        private String name;
        User(String n) {
            name = n;
        }
        @Override
        public String toString() {
            return String.format("User(%s)", name);
        }
    }

    private static class Developer {
        private String name;
        private String language;
        private int experience;
        private String mail;
        Developer(String name, String language, int experience, String mail) {
            this.name = name;
            this.language = language;
            this.experience = experience;
            this.mail = mail;
        }
        String getMail() { return mail; }
        int getExperience() { return experience; }
        String getLanguage() { return language; }
    }
}
