package 알고리즘고득점KIT.복습문제.완전탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 모의고사 {

    private static final int[] FIRST_MATH_AVERSE_PATTERN = {1, 2, 3, 4, 5};
    private static final int[] SECOND_MATH_AVERSE_PATTERN = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] THIRD_MATH_AVERSE_PATTERN = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] answers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) answers[i] = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();

        int[] winners = getWinnerWithMaxCorrectAnswers(answers);
        String winnerNumbers = Arrays.stream(winners).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        bufferedWriter.write(winnerNumbers);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int[] getWinnerWithMaxCorrectAnswers(int[] answers) {
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            // 수포자들의 찍기 패턴이 주기적으로 반복되므로 모듈러 연산을 사용하여 패턴 배열의 유효한 인덱스 범위 내에서 답을 반복해서 찾기 위함이다.
            if (answer == FIRST_MATH_AVERSE_PATTERN[i % FIRST_MATH_AVERSE_PATTERN.length]) scores[0]++;
            if (answer == SECOND_MATH_AVERSE_PATTERN[i % SECOND_MATH_AVERSE_PATTERN.length]) scores[1]++;
            if (answer == THIRD_MATH_AVERSE_PATTERN[i % THIRD_MATH_AVERSE_PATTERN.length]) scores[2]++;
        }

        int maxScore = 0;
        for (int score : scores) {
            if (score > maxScore) maxScore = score;
        }

        List<Integer> winners = new ArrayList<>();
        if (scores[0] == maxScore) winners.add(1);
        if (scores[1] == maxScore) winners.add(2);
        if (scores[2] == maxScore) winners.add(3);

        return winners.stream().mapToInt(i -> i).toArray();
    }
}
