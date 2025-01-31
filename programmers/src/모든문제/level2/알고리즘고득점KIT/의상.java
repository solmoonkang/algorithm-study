package 모든문제.level2.알고리즘고득점KIT;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    // TODO: 스트림 API 활용 능력이 미숙함.
    public int solution(String[][] clothes) {
        Map<String, Integer> combination = new HashMap<>();

        for (String[] clothe : clothes) {
            combination.put(clothe[1], combination.getOrDefault(clothe[1], 0) + 1);
        }

        return combination.values().stream()
                .map(count -> count + 1)
                .reduce(1, (a, b) -> a * b) - 1;
    }

    public static void main(String[] args) {
        의상 problem = new 의상();

        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println("problem = " + problem.solution(clothes1));

        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println("problem = " + problem.solution(clothes2));
    }
}
