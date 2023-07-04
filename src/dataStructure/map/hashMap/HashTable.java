package dataStructure.map.hashMap;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashTable {


    public static void main(String[] args) {

        // ======== HashTable 선언하기 ======== //

        // 타입 설정을 하지 않고, Object 를 설정한다
        HashTable hashTable = new HashTable();

        // <Integer, Integer> 타입을 선언한다
        Hashtable<Integer, Integer> integerHashtable1 = new Hashtable<Integer, Integer>();

        // new 는 타입 생략이 가능하다
        Hashtable<Integer, Integer> integerHashtable2 = new Hashtable<>();

        // integerHashtable1 의 Hashtable 을 integerHashtable3 로 값을 이전시킨다
        Hashtable<Integer, Integer> integerHashtable3 = new Hashtable<Integer, Integer>(integerHashtable1);

        // 초기 용량을 10으로 지정한다
        Hashtable<Integer, Integer> integerHashtable4 = new Hashtable<Integer, Integer>(10);

        // 변수를 선언하고, 초기값을 지정한다
        Hashtable<Integer, Integer> integerHashtable5 = new Hashtable<Integer, Integer>() {{

            put(1, 100);
            put(2, 200);
        }};

        // <String, String> 타입을 선언한다
        Hashtable<String, String> stringHashtable = new Hashtable<String, String>();

        // <Character, Character> 타입을 선언한다
        Hashtable<Character, Character> characterHashtable = new Hashtable<Character, Character>();


        // ======== HashTable 값 추가하기 ======== //

        // Hashtable 을 선언한다
        Hashtable<String, String> stringHashtable1 = new Hashtable<String, String>();

        // 값을 추가해준다
        stringHashtable1.put("1", "Hello");
        stringHashtable1.put("2", "World");
        stringHashtable1.put("3", "Good-Bye");
        stringHashtable1.put("4", "Awesome");
        stringHashtable1.put("2", "Hello-World");

        // 결과를 출력한다
        System.out.println(stringHashtable1);
        System.out.println("---------------------------------------------------------");


        // ======== HashTable 값 삭제하기 ======== //

        // 값을 삭제해준다
        stringHashtable1.remove("2");

        // 결과를 출력한다
        System.out.println(stringHashtable1);

        // 모든 값을 삭제해준다
        stringHashtable1.clear();

        // 결과를 출력한다
        System.out.println(stringHashtable1);
        System.out.println("---------------------------------------------------------");


        // ======== HashTable 크기 구하기 ======== //

        // Hashtable 을 선언한다
        Hashtable<String, String> stringHashtable2 = new Hashtable<String, String>();

        // 값을 추가해준다
        stringHashtable2.put("1", "Hello");
        stringHashtable2.put("2", "World");
        stringHashtable2.put("3", "Good-Bye");
        stringHashtable2.put("4", "Awesome");

        // 결과를 출력한다
        System.out.println(stringHashtable2);

        // 크기를 출력한다
        System.out.println("SIZE : " + stringHashtable2.size());
        System.out.println("---------------------------------------------------------");


        // ======== HashTable 값 출력하기 ======== //

        // -------- 향상된 for 문 -------- //

        // 향상된 for 문을 사용하여 HashTable 값을 출력한다
        for (Map.Entry<String, String> entry : stringHashtable2.entrySet()) {

            System.out.println("KEY : " + entry.getKey() + ", VALUE : " + entry.getValue());
        }

        System.out.println("---------------------------------------------------------");

        // -------- Iterator 방식 -------- //

        // Iterator 를 Entry 로 선언하여 entrySet() 의 iterator() 방식으로 가져온다
        Iterator<Entry<String, String>> iterator = stringHashtable2.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<String, String> entry = iterator.next();

            System.out.println("KEY : " + entry.getKey() + ", VALUE : " + entry.getValue());
        }

        System.out.println("---------------------------------------------------------");

        // Iterator 를 String 타입으로 선언하여, HashTable 의 Key 값을 iterator 형태로 집어넣는다
        Iterator<String> iterator2 = stringHashtable2.keySet().iterator();

        // String 을 반복하여 String 의 Key 값에 해당하는 Value 값을 반복해서 출력한다
        while (iterator2.hasNext()) {

            String key = iterator2.next();

            System.out.println("KEY : " + key + ", VALUE : " + stringHashtable2.get(key));
        }
    }
}

