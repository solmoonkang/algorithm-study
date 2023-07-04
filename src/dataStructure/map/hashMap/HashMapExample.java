package dataStructure.map.hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public String comparison(String[] array1, String[] array2) {

        String different = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String arr1 : array1) {

            hashMap.put(arr1, hashMap.getOrDefault(arr1, 0) + 1);
        }

        for (String arr2 : array2) {

            hashMap.put(arr2, hashMap.get(arr2) - 1);
        }

        for (String key : hashMap.keySet()) {

            if (hashMap.get(key) != 0) {
                different += key + "";
            }
        }

        return different;
    }


    public static void main(String[] args) {

        String[] array_1 = {"a", "b", "c", "a","f","z"};
        String[] array_2 = {"a", "b", "c"};

        HashMapExample hashMapExample = new HashMapExample();

        System.out.println("Different : " + hashMapExample.comparison(array_1, array_2));
    }
}
