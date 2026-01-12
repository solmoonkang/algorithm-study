package 알고리즘분류.문자열.복습문제;

import java.io.*;

public class OX퀴즈 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            String OX = bufferedReader.readLine();

            int score = calculateScore(OX);
            bufferedWriter.write(score + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateScore(String OX) {
        char[] problems = OX.toCharArray();

        int score = 0;
        int consecutiveO = 0;

        for (int i = 0; i < OX.length(); i++) {
            char currentScore = problems[i];
            if (currentScore == 'O') {
                consecutiveO++;
                score += consecutiveO;
            } else {
                consecutiveO = 0;
            }
        }

        return score;
    }
}
