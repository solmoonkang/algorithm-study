package programmers.모든문제.level1.복습문제;

import java.util.stream.IntStream;

public class 내적 {

    public int solution_iterator(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += (a[i] * b[i]);
        }

        return answer;
    }

    public int solution_stream(int[] a, int[] b) {
        return IntStream.range(0, a.length)
                .map(i -> a[i] * b[i])
                .sum();
    }

    public static void main(String[] args) {
        내적 problem = new 내적();

        int[] a1 = {1,2,3,4};
        int[] b1 = {-3,-1,0,2};
        System.out.println("problem = " + problem.solution_iterator(a1, b1));
        System.out.println("problem = " + problem.solution_stream(a1, b1));

        int[] a2 = {-1,0,1};
        int[] b2 = {1,0,-1};
        System.out.println("problem = " + problem.solution_iterator(a2, b2));
        System.out.println("problem = " + problem.solution_stream(a2, b2));
    }
}
