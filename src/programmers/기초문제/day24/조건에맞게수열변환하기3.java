package programmers.기초문제.day24;

import java.util.Arrays;

public class 조건에맞게수열변환하기3 {

    public int[] solution(int[] arr, int k) {

        // 만약 k가 홀수라면 arr의 모든 원소에 k를 곱하고,
        // 만약 k가 짝수라면 arr의 모든 원소에 k를 더한다
        // 이러한 변환을 마친 후 arr를 반환하라

        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (k % 2 == 1) {

                answer[i] = arr[i] * k;

            } else {

                answer[i] = arr[i] + k;

            }
        }
        return answer;
    }

    public static void main(String[] args) {

        조건에맞게수열변환하기3 convert = new 조건에맞게수열변환하기3();

        int[] arr = {1, 2, 3, 100, 99, 98};

        System.out.println("Result : " + Arrays.toString(convert.solution(arr, 3)));
        System.out.println("Result : " + Arrays.toString(convert.solution(arr, 2)));
    }
}
