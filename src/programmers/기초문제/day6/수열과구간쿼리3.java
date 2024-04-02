package programmers.기초문제.day6;

import java.util.Arrays;

public class 수열과구간쿼리3 {

    public int[] solution(int[] arr, int[][] queries) {

        int E;

        for (int i = 0; i < queries.length; i++) {
            E = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]];
            arr[queries[i][1]] = E;
        }

        return arr;
    }

    public static void main(String[] args) {

        수열과구간쿼리3 query = new 수열과구간쿼리3();

        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 3},{1, 2},{1, 4}};

        System.out.println("Result : " + Arrays.toString(query.solution(arr, queries)));
    }
}
