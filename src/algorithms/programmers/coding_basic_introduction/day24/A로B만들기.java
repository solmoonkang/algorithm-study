package algorithms.programmers.coding_basic_introduction.day24;

import java.util.HashMap;

public class A로B만들기 {

    /**
     * [ 문제 설명 ]
     * 문자열 before와 after가 매개변수로 주어질 때, before의 순서를 바꾸어 after를 만들 수 있으면 1을, 만들 수 없으면 0을 반환하라.
     */
    public int solution(String before, String after) {
        // before의 각 문자들을 after 문자열과 비교해서 동일하면 1을 동일하지 않으면 0을 반환한다.
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char b : before.toCharArray()) {
            hashMap.put(b, hashMap.getOrDefault(b , 0) + 1);
        }

        for (char a : after.toCharArray()) {
            if (!hashMap.containsKey(a) || hashMap.get(a) == 0) {
                return 0;
            }
            hashMap.put(a, hashMap.get(a) - 1);
        }

        if (hashMap.values().stream().anyMatch(i -> i != 0)) {
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        A로B만들기 makingBFromA = new A로B만들기();
        System.out.println("Result: " + makingBFromA.solution("olleh", "hello"));
        System.out.println("Result: " + makingBFromA.solution("allpe", "apple"));
    }
}
