package programmers.foundation.level0.day7;

import java.util.Arrays;

public class 수열과구간쿼리4 {

    public int[] solution(int[] arr, int[][] queries) {

        // answer 배열을 arr 배열과 동일한 크기로 초기화
        int[] answer = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < queries.length; i++) {

            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            for (int j = s; j <= e; j++) {

                if (j % k == 0) {
                    answer[j] += 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        수열과구간쿼리4 query = new 수열과구간쿼리4();

        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 1},{0, 3, 2},{0, 3, 3}};

        System.out.println("Result : " + Arrays.toString(query.solution(arr, queries)));
    }
}
