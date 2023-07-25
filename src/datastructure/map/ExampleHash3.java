package datastructure.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleHash3 {

    public static void main(String[] args) {

        Map<String, String> stringMap = new HashMap<>();

        stringMap.put("apple", "과일");
        stringMap.put("banana", "과일");
        stringMap.put("peach", "과일");
        stringMap.put("grape", "과일");

        stringMap.put("banana", "바나나");
        stringMap.put("peach", "복숭아");
        stringMap.put("grape", "포도");

        for (String fruit : stringMap.keySet()) {

            // 순서에 상관없이 출력되며, 이미 존재하는 Key 값에 중복되는 값을 put( ) 하여도 가장 최근에 입력한 값으로 저장 및 출력된다
            System.out.println("Key : " + fruit + ", Value : " + stringMap.get(fruit));
        }


        Map<String, List<String>> listMap = new HashMap<>();
    }
}
