package programmers.입문문제.day15;

import java.util.HashMap;

public class 영어가싫어요 {

    /**
     * [ 문제 설명 ]
     * 영어가 싫은 머쓱이는 영어로 표기되어있는 숫자를 수로 바꾸려고 합니다.
     * 문자열 numbers가 매개변수로 주어질 때, numbers를 정수로 바꿔 반환하라.
     */
    public long solution(String numbers) {
        String[] stringNumbers = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < stringNumbers.length; i++) {
            hashMap.put(stringNumbers[i], i);
        }

        StringBuilder current = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (char c : numbers.toCharArray()) {
            current.append(c);
            if (hashMap.containsKey(current.toString())) {
                result.append(hashMap.get(current.toString()));
                current = new StringBuilder();
            }
        }
        return Long.parseLong(result.toString());
    }

    public long otherSolution(String numbers) {
        String[] stringNumbers = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers = numbers.replaceAll(stringNumbers[i], String.valueOf(i));
        }
        return Long.parseLong(numbers);
    }

    public static void main(String[] args) {
        영어가싫어요 hateEnglish = new 영어가싫어요();
        System.out.println("Result: " + hateEnglish.solution("onetwothreefourfivesixseveneightnine"));
        System.out.println("Result: " + hateEnglish.solution("onefourzerosixseven"));

        System.out.println("Result: " + hateEnglish.otherSolution("onetwothreefourfivesixseveneightnine"));
    }
}
