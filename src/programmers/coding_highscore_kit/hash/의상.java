package programmers.coding_highscore_kit.hash;

import java.util.Arrays;
import java.util.HashMap;

import static java.util.stream.Collectors.*;

public class 의상 {

    /**
     * 모든 경우의 수를 다 구하는 것
     * 의상 종류는 중복될 수 없다 ( 즉, 하나의 의상 종류만을 가질 수 있다 )
     */

    public int solution_stream(String[][] clothes) {

        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
//                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
                .reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
    }


    public int solution_hash(String[][] clothes) {

        int answer = 1;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] cloth : clothes) {

            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
        }

        for (Integer value : hashMap.values()) {

            answer *= (value + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {

        String[][] cloth1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] cloth2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        의상 clothes = new 의상();

        System.out.println("Clothes : " + clothes.solution_hash(cloth1));
        System.out.println("Clothes : " + clothes.solution_hash(cloth2));
        System.out.println("------------------------------------------");

        System.out.println("Clothes : " + clothes.solution_stream(cloth1));
        System.out.println("Clothes : " + clothes.solution_stream(cloth2));
    }
}
