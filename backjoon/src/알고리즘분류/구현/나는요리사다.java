package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 나는요리사다 {

    private static final int NUMBER_OF_PARTICIPANTS = 5;
    private static final int NUMBER_OF_SCORES = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int winner = 0;
        int maxScore = 0;

        for (int i = 0; i < NUMBER_OF_PARTICIPANTS; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int sum = 0;

            for (int j = 0; j < NUMBER_OF_SCORES; j++) {
                sum += Integer.parseInt(stringTokenizer.nextToken());
            }

            if (sum > maxScore) {
                maxScore = sum;
                winner = i + 1;
            }
        }

        bufferedWriter.write(winner + " " + maxScore);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
