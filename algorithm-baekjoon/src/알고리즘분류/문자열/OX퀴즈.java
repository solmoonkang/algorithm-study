package 알고리즘분류.문자열;

import java.io.*;

public class OX퀴즈 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            String oxQuizResult = bufferedReader.readLine();

            int score = 0;              // 총 점수를 저장할 변수
            int currentScore = 0;       // 현재 O의 연속 개수를 저장할 변수

            for (char oOrX : oxQuizResult.toCharArray()) {
                if (oOrX == 'O') {
                    currentScore++;             // O가 나오면 currentScore를 증가
                    score += currentScore;      // 현재 점수를 총 점수에 더함
                } else {
                    currentScore = 0;           // X가 나오면 currentScore를 초기화
                }
            }

            bufferedWriter.write(score + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
