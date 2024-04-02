package programmers.기초문제.day20;

import java.util.Arrays;

public class 배열의길이에따라다른연산하기 {

    public int[] solution(int[] arr, int n) {

        // arr 의 길이가 홀수라면, arr 의 모든 짝수 인덱스 위치에 n을 더한 배열을
        // arr 의 길이가 짝수라면, arr 의 모든 홀수 인덱스 위치에 n을 더한 배열을 반환하라

        int[] answer = arr.clone();

        if (arr.length % 2 == 1) {

            for (int i = 0; i < arr.length; i += 2) {

                answer[i] = arr[i] + n;

            }

        } else {

            for (int i = 1; i < arr.length; i += 2) {

                answer[i] = arr[i] + n;

            }

        }

        return answer;
    }

    public static void main(String[] args) {

        배열의길이에따라다른연산하기 calcul = new 배열의길이에따라다른연산하기();

        int[] arr1 = {49, 12, 100, 276, 33};
        int[] arr2 = {444, 555, 666, 777};

        System.out.println("Result : " + Arrays.toString(calcul.solution(arr1, 27)));
        System.out.println("Result : " + Arrays.toString(calcul.solution(arr2, 100)));
    }
}
