package 알고리즘고득점KIT.전체문제.동적계획법;

import java.io.*;

public class 정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = solution(triangle);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int solution(int[][] triangle) {
        return 0;
    }
}
