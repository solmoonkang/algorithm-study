package programmers.기출문제.KAKAO_BLIND_RECRUITMENT_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 실패율 {

    // TODO: 해당 문제는 다시 한 번 풀어보자.
    public int[] solution(int N, int[] stages) {
        int[] playerCount = new int[N + 2];
        int totalPlayers = stages.length;

        for (int stage : stages) {
            if (stage <= N) playerCount[stage]++;
        }

        List<double[]> failureRates = new ArrayList<>();
        int playersAtCurrentStage = totalPlayers;

        for (int i = 1; i <= N; i++) {
            if (playersAtCurrentStage == 0) failureRates.add(new double[]{i, 0.0});
            else {
                double failureRate = (double) playerCount[i] / playersAtCurrentStage;
                failureRates.add(new double[]{i, failureRate});
            }

            playersAtCurrentStage -= playerCount[i];
        }

        failureRates.sort((a, b) -> {
            if (Double.compare(b[1], a[1]) != 0) return Double.compare(b[1], a[1]);

            return Integer.compare((int) a[0], (int) b[0]);
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failureRates.get(i)[0];
        }

        return answer;
    }

    public static void main(String[] args) {
        실패율 problem = new 실패율();

        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println("problem = " + Arrays.toString(problem.solution(5, stages1)));

        int[] stages2 = {4, 4, 4, 4, 4};
        System.out.println("problem = " + Arrays.toString(problem.solution(4, stages2)));
    }
}
