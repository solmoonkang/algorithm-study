package programmers.기초문제.day20;

import java.util.Arrays;

public class 배열의길이를2의거듭제곱으로만들기 {

    public int[] solution(int[] arr) {

        // arr 의 길이가 2의 정수 거듭 제곱이 되도록 arr 뒤에 정수 0을 추가한다
        // arr 에 최소한의 개수로 0을 추가한 배열을 반환하라

        int length = 1;

        while (length < arr.length) {

            length *= 2;

        }

        int[] answer = new int[length];

        System.arraycopy(arr, 0, answer, 0, arr.length);

        return answer;
    }

    public static void main(String[] args) {

        배열의길이를2의거듭제곱으로만들기 length = new 배열의길이를2의거듭제곱으로만들기();

        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {58, 172, 746, 89};

        System.out.println("Result : " + Arrays.toString(length.solution(arr1)));
        System.out.println("Result : " + Arrays.toString(length.solution(arr2)));
    }
}
