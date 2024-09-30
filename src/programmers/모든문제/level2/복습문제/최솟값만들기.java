package programmers.모든문제.level2.복습문제;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값만들기 {

    // TODO: 효율성 검사 시 시간초과 발생, 따라서 반복문에서 B를 내림차순으로 정렬해야 한다.
    public int solution(int[] A, int[] B) {
        Integer[] arrayB = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(A);
        Arrays.sort(arrayB, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * arrayB[i];
            // answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        최솟값만들기 problem = new 최솟값만들기();

        int[] A1 = {1, 4, 2};
        int[] B1 = {5, 4, 4};
        System.out.println("problem = " + problem.solution(A1, B1));

        int[] A2 = {1, 2};
        int[] B2 = {3, 4};
        System.out.println("problem = " + problem.solution(A2, B2));
    }
}
