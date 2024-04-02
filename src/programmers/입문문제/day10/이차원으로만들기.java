package programmers.입문문제.day10;

import java.util.Arrays;

public class 이차원으로만들기 {

    /**
     * [ 문제 설명 ]
     * 정수 배열 num_list와 정수 n이 매개변수로 주어집니다. num_list를 다음 설명과 같이 2차원 배열로 바꿔 반환하라.
     * num_list가 [1, 2, 3, 4, 5, 6, 7, 8] 로 길이가 8이고 n이 2이므로 num_list를 2 * 4 배열로 다음과 같이 변경합니다.
     * 2차원으로 바꿀 때에는 num_list의 원소들을 앞에서부터 n개씩 나눠 2차원 배열로 변경합니다.
     */
    public int[][] solution(int[] num_list, int n) {
        // TODO: 이차원 배열 구현에서 이중 for문으로 배열의 요소를 할당하는 방법에 대해서 미숙하다.
        int m = num_list.length / n;
        int[][] answer = new int[m][n];

        // i는 2차원 배열의 행 인덱스로, num_list에서 n개의 원소를 구분하는 데 사용된다.
        // i가 증가할 때마다, n개의 새로운 원소를 시작하는 위치로 점프한다.
        for (int i = 0; i < m; i++) {
            // j는 2차원 배열의 각 행에서의 열 인덱스로, n개의 원소 내에서의 위치를 나타낸다.
            for (int j = 0; j < n; j++) {
                // n은 num_list를 몇 개의 원소로 나눌지 결정하는 값이다.
                answer[i][j] = num_list[i * n + j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        이차원으로만들기 twoDimensionalArray = new 이차원으로만들기();
        int[] firstNumList = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] secondNumList = {100, 95, 2, 4, 5, 6, 18, 33, 948};
        System.out.println("Result: " + Arrays.deepToString(twoDimensionalArray.solution(firstNumList, 2)));
        System.out.println("Result: " + Arrays.deepToString(twoDimensionalArray.solution(secondNumList, 3)));
    }
}
