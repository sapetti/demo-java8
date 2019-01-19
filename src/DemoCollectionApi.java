import java.util.HashMap;
import java.util.Map;

public class DemoCollectionApi {

    public static void main(String[] args) {

        Map<Integer, String> myMap = new HashMap<>();


        System.out.println(myMap.getOrDefault(1, "Not Found"));


        myMap.put(1, "A");
        myMap.put(2, "B");
        myMap.put(3, "C");


//        myMap.putIfAbsent(4, "D");
//        myMap.putIfAbsent(3, "Does not update");


        myMap.computeIfPresent(1, (k, v) -> v + "A");
        myMap.computeIfAbsent(4, k -> "D" + k);


//        myMap.compute(1, (k, v) ->  "A" + k + v);
//        myMap.compute(14, (k, v) -> "D" + k + v);

//        myMap.merge(1, "Merged", (vMap, vProvided) -> vMap + vProvided);


//        Map<Integer, String> myMap2 = new HashMap<>();
//        myMap2.put(2, "b");
//        myMap2.put(3, "c");
//        myMap2.put(4, "d");

        myMap.forEach((k, v) -> System.out.println(k + " - " + v));

    }
}
