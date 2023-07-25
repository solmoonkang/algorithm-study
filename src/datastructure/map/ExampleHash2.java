package datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class ExampleHash2 {

    public static void main(String[] args) {

        // ======= entrySet(  ) =======
        System.out.println("======= entrySet(  ) =======");

        Map<String, Object> fruit = new HashMap<>();

        fruit.put("red", "apple");
        fruit.put("yellow", "banana");
        fruit.put("green", "melon");
        fruit.put("purple", "grape");

        System.out.println("Fruit : " + fruit);

        // entrySet( ) 을 사용하여 Map 의 모든 Key, Value 값을 꺼내온다
        for (Map.Entry<String, Object> entry : fruit.entrySet()) {

            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }


        // ======= keySet(  ) =======
        System.out.println("======= keySet(  ) =======");

        Map<String, Object> number = new HashMap<>();

        number.put("one", "first");
        number.put("two", "second");
        number.put("three", "third");

        System.out.println("Number : " + number);

        for (String num : number.keySet()) {

            System.out.println("Key : " + num + ", Value : " + number.get(num));
        }
    }
}
