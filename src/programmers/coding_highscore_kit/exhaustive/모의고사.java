package programmers.coding_highscore_kit.exhaustive;

import java.util.Arrays;

public class 모의고사 {

    public int[] solution(int[] answers) {

        // 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 한다.
        // 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍는다.
            // 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
            // 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
            // 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
        // 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 반환하라

        int[] answer = {};

        int[] first_retire_answers = {1, 2, 3, 4, 5};
        int[] second_retire_answers = {2, 1, 2, 3, 2};
        int[] third_retire_answers = {3, 3, 1, 1, 2};

        int first_count = 0;
        int second_count = 0;
        int third_count = 0;

        for (int i = 0; i < answers.length; i++) {

            if (answers[i] == first_retire_answers[i]) {
                first_count++;
            } else if (answers[i] == second_retire_answers[i]) {
                second_count++;
            } else if (answers[i] == third_retire_answers[i]) {
                third_count++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        모의고사 test = new 모의고사();

        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        System.out.println("Result: " + Arrays.toString(test.solution(answers1)));
        System.out.println("Result: " + Arrays.toString(test.solution(answers2)));
    }
}
