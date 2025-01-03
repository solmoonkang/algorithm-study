package programmers.알고리즘고득점KIT.해시;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    public int solution(String[][] clothes) {
        Map<String, Integer> clothesCombinationMap = new HashMap<>();

        for (String[] clothe : clothes) {
            clothesCombinationMap.put(clothe[1], clothesCombinationMap.getOrDefault(clothe[1], 0) + 1);
        }

        int combination = 1;
        for (Map.Entry<String, Integer> entry : clothesCombinationMap.entrySet()) {
            int combinationValue = entry.getValue();
            combination *= combinationValue + 1;
        }

        return combination - 1;
    }

    public static void main(String[] args) {
        의상 problem = new 의상();

        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println("problem = " + problem.solution(clothes1));


        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println("problem = " + problem.solution(clothes2));
    }
}
