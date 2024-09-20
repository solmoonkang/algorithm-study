package programmers.모든문제.level1.복습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 명예의전당1 {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> scoreList = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            scoreList.add(score[i]);
            Collections.sort(scoreList);

            if (scoreList.size() > k) scoreList.remove(0);
            answer[i] = scoreList.get(0);
        }

        return answer;
    }

    public static void main(String[] args) {
        명예의전당1 problem = new 명예의전당1();

        int[] score1 = {10, 100, 20, 150, 1, 100, 200};
        System.out.println("problem = " + Arrays.toString(problem.solution(3, score1)));

        int[] score2 = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        System.out.println("problem = " + Arrays.toString(problem.solution(4, score2)));
    }
}
