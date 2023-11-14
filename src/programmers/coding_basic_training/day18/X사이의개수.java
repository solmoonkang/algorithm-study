package programmers.coding_basic_training.day18;

import java.util.Arrays;

public class X사이의개수 {

    public int[] solution(String myString) {

        // myString 을 문자 "x"를 기준으로 나눴을 때, 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을 반환하라

        // spilt 메서드로 "x"를 기준으로 나누고 나눠진 문자열의 길이를 배열에 저장한다

        String[] str = myString.split("x", myString.length());

        int[] answer = new int[str.length];

        for (int i = 0; i < str.length; i++) {

            answer[i] = str[i].length();

        }

        return answer;
    }

    public static void main(String[] args) {

        X사이의개수 x = new X사이의개수();

        System.out.println("Result : " + Arrays.toString(x.solution("oxooxoxxox")));
        System.out.println("Result : " + Arrays.toString(x.solution("xabcxdefxghi")));
    }
}
