package programmers.coding_highscore_kit.exhaustive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

    /**
     * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 한다.
     * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍는다.
     *     1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, ...
     *     2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, ...
     *     3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 반환하라
     */

    public int[] solution(int[] answers) {
        // TODO: 완전탐색이 문제가 아니라 전체적으로 코드를 운영하는 능력이 부족하다. 특히 for문을 활용하는 능력이 미숙하여 공부가 필요하다.
        int[][] patterns = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] correctCount = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < correctCount.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    correctCount[j]++;
                }
            }
        }
        int maxCorrect = Math.max(correctCount[0], Math.max(correctCount[1], correctCount[2]));

        List<Integer> bestStudents = new ArrayList<>();
        for (int i = 0; i < correctCount.length; i++) {
            if (correctCount[i] == maxCorrect) {
                bestStudents.add(i + 1);
            }
        }

        return bestStudents.stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {

        모의고사 test = new 모의고사();

        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        System.out.println("Result: " + Arrays.toString(test.solution(answers1)));
        System.out.println("Result: " + Arrays.toString(test.solution(answers2)));
    }
}
