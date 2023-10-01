package programmers.coding_basic_training.level0.day16;

import java.util.Arrays;

public class 배열에서문자열대소문자변환하기 {

    public String[] solution(String[] strArr) {

        // 모든 원소가 알파벳으로만 이루어져 있을 때,
        // 배열에서 홀수번째 인덱스의 문자열은 모든 문자를 대문자로,
        // 배열에서 짝수번째 인덱스의 문자열은 모든 문자를 소문자로 바꿔서 반환하라

        String[] answer = new String[strArr.length];

        for (int i = 0; i < strArr.length; i++) {

            if (i % 2 == 0) {

                answer[i] = strArr[i].toLowerCase();

            } else {

                answer[i] = strArr[i].toUpperCase();

            }

        }

        return answer;
    }

    public static void main(String[] args) {

        배열에서문자열대소문자변환하기 convert = new 배열에서문자열대소문자변환하기();

        String[] strArr = {"AAA","BBB","CCC","DDD"};

        System.out.println("Result : " + Arrays.toString(convert.solution(strArr)));
    }
}
