package algorithms.programmers.coding_basic_training.day11;

import java.util.Arrays;

public class 문자개수세기 {

    public int[] solution(String my_string) {

        // my_string 에서 A, B, C, D, ..., Z의 개수를 순서대로 담은 길이 52인 정수 배열을 반환하라

        // 길이 52인 정수 배열을 선언
        int[] answer = new int[52];

        // 문자열을 순회
        for (int i = 0; i < my_string.length(); i++) {

            // 각 알파벳의 개수를 세기
            char c = my_string.charAt(i);

            // 대문자인 경우
            if (c >= 'A' && c <= 'Z') {

                // 'A' - 'A' = 0
                // 'B' - 'B' = 1
                // ...
                // 'Z' - 'Z' = 25
                answer[c - 'A']++;  // 각 대문자 알파벳에 해당하는 배열 인덱스를 얻을 수 있다

            // 소문자인 경우
            } else if (c >= 'a' && c <= 'z') {

                answer[26 + c - 'a']++;     // 26은 기존 배열에서 상위 인덱스부터 시작하기 때문에 더해준다

            }
        }

        return answer;
    }

    public static void main(String[] args) {

        문자개수세기 count = new 문자개수세기();

        System.out.println("Result : " + Arrays.toString(count.solution("Programmers")));
    }
}
