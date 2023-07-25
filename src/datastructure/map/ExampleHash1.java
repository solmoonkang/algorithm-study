package datastructure.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleHash1 {

    public static void main(String[] args) {

        // ======= put(  ) =======
        System.out.println("======= put(  ) =======");

        // String, String
        Map<String, String> data = new HashMap<>();

        data.put("list", "리스트");
        data.put("queue", "큐");
        data.put("set", "셋");

        System.out.println("Type : <String, String> " + data);

        // String, Integer
        Map<String, Integer> number = new HashMap<>();

        number.put("one", 1);
        number.put("two", 2);
        number.put("three", 3);

        System.out.println("Type : <String, Integer> " + number);

        // String, List<String>
        Map<String, List<String>> listMap = new HashMap<>();

        List<String> numberList = new ArrayList<>();

        numberList.add("one");
        numberList.add("two");
        numberList.add("three");

        listMap.put("numberMap", numberList);

        System.out.println("Type : <String, List<String>> " + numberList);



        // ======= get(  ) =======
        System.out.println("======= get(  ) =======");

        List<String> numList = listMap.get("numberMap");

        System.out.println("get( ) : " + numList);



        // ======= containsKey(  ) =======
        System.out.println("======= containsKey(  ) =======");

        System.out.println(data.containsKey("stack"));
        System.out.println(data.containsKey("queue"));

        System.out.println(numberList.contains("one"));
        System.out.println(numList.contains("five"));



        // ======= remove(  ) =======
        System.out.println("======= remove(  ) =======");

        data.put("array", "배열");
        data.put("string", "문자열");
        data.put("condition", "조건문");

        System.out.println(data);

        data.remove("condition");
        data.remove("string", "문자열");

        System.out.println(data);
    }
}
