package programmers.모든문제.level2.전체문제;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    /**
     * [ 문제 설명 ]
     * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
     * 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
     * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
     * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * numbers는 길이 1 이상 7 이하인 문자열입니다.
     * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
     * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
     */

    // TODO: 숫자 조합을 생성할 때, 숫자를 재조합해서 사용해서 스택오버가 발생한듯 하다. 따라서 해당 숫자를 사용했는지 표시해서 문제를 해결
    public int solution(String numbers) {
        char[] digits = numbers.toCharArray();
        Set<Integer> answer = new HashSet<>();

        generateCombinations("", digits, answer, new boolean[digits.length]);

        int count = 0;
        for (int number : answer) {
            if (isPrime(number)) count++;
        }

        return count;
    }

    public void generateCombinations(String current, char[] digits, Set<Integer> answer, boolean[] used) {
        if (!current.isEmpty() && current.charAt(0) != '0') answer.add(Integer.parseInt(current));

        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                generateCombinations(current + digits[i], digits, answer, used);
                used[i] = false;
            }
        }
    }

    public boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        소수찾기 findingPrimeNumbers = new 소수찾기();

        System.out.println("findingPrimeNumbers = " + findingPrimeNumbers.solution("17"));
        System.out.println("findingPrimeNumbers = " + findingPrimeNumbers.solution("011"));
    }
}
