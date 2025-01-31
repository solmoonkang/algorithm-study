package 모든문제.level1.전체문제;

import java.util.HashMap;
import java.util.Map;

public class 숫자짝꿍 {

    /**
     * [ 문제 설명 ]
     * 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여
     * 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다. (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다.)
     * X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
     *
     * 예를 들어, X = 3403이고 Y = 13203이라면,
     * X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다.
     *
     * 다른 예시로 X = 5525이고 Y = 1255이면
     * X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다.
     * (X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
     * 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
     * X, Y는 0으로 시작하지 않습니다.
     * X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.
     */
    public String solution(String X, String Y) {
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();

        for (char c : X.toCharArray()) {
            xMap.put(c, xMap.getOrDefault(c, 0) + 1);
        }

        for (char c : Y.toCharArray()) {
            yMap.put(c, yMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder builder = new StringBuilder();

        for (char key = '9'; key >= '0'; key--) {
            if (xMap.containsKey(key) && yMap.containsKey(key)) {
                int commonValue = Math.min(xMap.get(key), yMap.get(key));

                for (int i = 0; i < commonValue; i++) {
                    builder.append(key);
                }
            }
        }

        String largestNumber = builder.toString();

        return largestNumber.isEmpty() ? "-1" : largestNumber.charAt(0) == '0' ? "0" : largestNumber;
    }

    public static void main(String[] args) {
        숫자짝꿍 numberPairs = new 숫자짝꿍();

        System.out.println("numberPairs = " + numberPairs.solution("100", "2345"));
        System.out.println("numberPairs = " + numberPairs.solution("100", "203045"));
        System.out.println("numberPairs = " + numberPairs.solution("100", "123450"));
        System.out.println("numberPairs = " + numberPairs.solution("12321", "42531"));
        System.out.println("numberPairs = " + numberPairs.solution("5525", "1255"));
    }
}
