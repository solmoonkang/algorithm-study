package programmers.기초문제.day25;

import java.util.Arrays;

public class 정사각형으로만들기 {

    /**
     * [ 문제 설명 ]
     * 이차원 정수 배열 arr이 매개변수로 주어집니다.
     * arr의 행의 수가 더 많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고,
     * 열의 수가 더 많다면 행의 수가 열의 수와 같아지도록 각 열의 끝에 0을 추가한 이차원 배열을 반환하라.
     *
     * 행 == arr.length, 열 == arr[0].length
     */
    public int[][] solution(int[][] arr) {
        // 이차원 배열 arr의 행과 열 중 가장 큰 값으로 answer 배열의 크기를 설정한다.
        int maxLength = Math.max(arr.length, arr[0].length);
        int[][] answer = new int[maxLength][maxLength];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        정사각형으로만들기 squareMaker = new 정사각형으로만들기();
        int[][] firstArr = {{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}};
        int[][] secondArr = {{57, 192, 534, 2}, {9, 345, 192, 999}};
        int[][] thirdArr = {{1, 2}, {3, 4}};
        System.out.println("Result: " + Arrays.deepToString(squareMaker.solution(firstArr)));
        System.out.println("Result: " + Arrays.deepToString(squareMaker.solution(secondArr)));
        System.out.println("Result: " + Arrays.deepToString(squareMaker.solution(thirdArr)));
    }
}
