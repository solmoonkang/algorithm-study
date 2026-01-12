package 알고리즘분류.구현;

import java.io.*;
import java.util.Arrays;

public class SolvedAc {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] difficultyOpinion = new int[N];
        for (int i = 0; i < N; i++) difficultyOpinion[i] = Integer.parseInt(bufferedReader.readLine());

        int difficulty = calculateProblemDifficulty(N, difficultyOpinion);
        bufferedWriter.write(String.valueOf(difficulty));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateProblemDifficulty(int N, int[] difficultyOpinion) {
        Arrays.sort(difficultyOpinion);
        int removeOpinion = (int) Math.round((N * 0.15));

        int sum = 0;
        for (int i = removeOpinion; i < N - removeOpinion; i++) {
            sum += difficultyOpinion[i];
        }

        int remainOpinion = N - (removeOpinion * 2);
        double averageOpinion = (double) sum / remainOpinion;

        return (int) Math.round(averageOpinion);
    }
}
