package programmers.모든문제.level1.복습문제;

import java.util.Arrays;

public class X만큼간격이있는N개의숫자 {

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        X만큼간격이있는N개의숫자 problem = new X만큼간격이있는N개의숫자();

        System.out.println("problem = " + Arrays.toString(problem.solution(2, 5)));
        System.out.println("problem = " + Arrays.toString(problem.solution(4, 3)));
        System.out.println("problem = " + Arrays.toString(problem.solution(-4, 2)));
    }
}
