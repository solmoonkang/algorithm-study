package programmers.모든문제.level1.복습문제;

import java.util.Arrays;

public class 과일장수 {

    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);

        int totalScore = 0;
        for (int i = score.length - m; i >= 0; i -= m) {
            int minScore = score[i];
            totalScore += minScore * m;
        }

        return totalScore;
    }

    public static void main(String[] args) {
        과일장수 problem = new 과일장수();

        int[] score1 = {1, 2, 3, 1, 2, 3, 1};
        System.out.println("problem = " + problem.solution(3, 4, score1));

        int[] score2 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println("problem = " + problem.solution(4, 3, score2));
    }
}
