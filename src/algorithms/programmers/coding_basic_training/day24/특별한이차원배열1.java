package algorithms.programmers.coding_basic_training.day24;

import java.util.Arrays;

public class 특별한이차원배열1 {

    /**
     * 정수 n이 매개변수로 주어질 때, 다음과 같은 n × n 크기의 이차원 배열 arr를 반환하라.
     * arr[i][j] (0 ≤ i, j < n)의 값은 i = j라면 1, 아니라면 0입니다.
     */
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (answer[i] == answer[j]) {
                    answer[i][j] = 1;
                } else {
                    answer[i][j] = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        특별한이차원배열1 special = new 특별한이차원배열1();
        System.out.println("Result: " + Arrays.deepToString(special.solution(3)));
        System.out.println("Result: " + Arrays.deepToString(special.solution(6)));
    }
}
