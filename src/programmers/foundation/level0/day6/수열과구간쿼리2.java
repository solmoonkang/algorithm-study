package programmers.foundation.level0.day6;

import java.util.Arrays;

public class 수열과구간쿼리2 {     // Review Required

    public int[] solution(int[] arr, int[][] queries) {

        int[] answer = new int[queries.length];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for (int i = 0; i < queries.length; i++) {
//            answer[i] = Integer.MAX_VALUE;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (arr[j] > queries[i][2]) {
                    // answer[i] 는 현재까지 최솟값을 추적하고, arr[j] 는 현재 위치에서의 값
                    answer[i] = Math.min(answer[i], arr[j]);
                }
            }
            if (answer[i] == Integer.MAX_VALUE) answer[i] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {

        수열과구간쿼리2 query = new 수열과구간쿼리2();

        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 2}, {0, 3, 2}, {0, 2, 2}};

        System.out.println("Result : " + Arrays.toString(query.solution(arr, queries)));
    }
}
