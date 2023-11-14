package programmers.coding_basic_training.day14;

import java.util.Arrays;

public class 수열과구간쿼리1 {

    public int[] solution(int[] arr, int[][] queries) {

        // 정수 배열 arr 와 2차원 정수 배열 queries 이 주어집니다. queries 의 원소는 각각 하나의 query 를 나타내며, [s, e] 꼴입니다.
        // 각 query 마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 arr[i]에 1을 더합니다.
        // 위 규칙에 따라 queries 를 처리한 이후의 arr 를 return 하는 solution 함수를 완성해 주세요.

        // 즉, queries 각 원소에 해당하는 인덱스 부분을 arr 배열의 원소값에 1씩 더해서 반환하라

        for (int i = 0; i < queries.length; i++) {

            int s = queries[i][0];
            int e = queries[i][1];

            for (int j = s; j <= e; j++) {

                arr[j] += 1;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        수열과구간쿼리1 query1 = new 수열과구간쿼리1();

        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 1}, {1, 2}, {2, 3}};

        System.out.println("Result : " + Arrays.toString(query1.solution(arr, queries)));
    }
}
