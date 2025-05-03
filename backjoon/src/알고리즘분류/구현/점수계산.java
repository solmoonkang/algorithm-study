package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 점수계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] gradingResults = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            gradingResults[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int additionalPoints = 0;
        int totalGrading = 0;

        for (int i = 0; i < N; i++) {
            if (gradingResults[i] == 1) {
                additionalPoints++;
                totalGrading += additionalPoints;
            } else {
                additionalPoints = 0;
            }
        }

        bufferedWriter.write(String.valueOf(totalGrading));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
