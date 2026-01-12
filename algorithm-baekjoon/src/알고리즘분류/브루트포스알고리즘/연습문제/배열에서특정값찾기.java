package 알고리즘분류.브루트포스알고리즘.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 배열에서특정값찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        int[] sequences = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        bufferedWriter.write(findSpecificValue(T, sequences));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String findSpecificValue(int targetNumber, int[] sequences) {
        boolean isFound = false;

        for (int sequence : sequences) {
            if (sequence == targetNumber) {
                isFound = true;
                break;
            }
        }

        return isFound ? "FOUND" : "NOT FOUND";
    }
}
