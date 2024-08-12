package programmers.모든문제.level0.코딩테스트입문;

import java.util.Arrays;

public class 등수매기기 {

    // TODO: 정렬을 하는 부분에서 부족함이 있음. 그리고 인덱스를 활용하는 부분이 미숙함.

    public int[] solution(int[][] score) {
        int[] average = new int[score.length];
        int[] ranks = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            average[i] = (score[i][0] + score[i][1]) / 2;
        }

        Integer[][] indexedScores = new Integer[score.length][2];
        for (int i = 0; i < score.length; i++) {
            indexedScores[i][0] = average[i];
            indexedScores[i][1] = i;
        }

        Arrays.sort(indexedScores, (a, b) -> b[0].compareTo(a[0]));

        int currentRank = 1;
        for (int i = 0; i < score.length; i++) {
            if (i > 0 && indexedScores[i][0].equals(indexedScores[i - 1][0])) {
                ranks[indexedScores[i][1]] = ranks[indexedScores[i - 1][1]];
            } else {
                ranks[indexedScores[i][1]] = currentRank;
            }

            currentRank++;
        }

        return ranks;
    }

    public static void main(String[] args) {
        등수매기기 rankingSystem = new 등수매기기();

        int[][] score1 = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
        System.out.println("rankingSystem = " + Arrays.toString(rankingSystem.solution(score1)));

        int[][] score2 = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
        System.out.println("rankingSystem = " + Arrays.toString(rankingSystem.solution(score2)));
    }
}
