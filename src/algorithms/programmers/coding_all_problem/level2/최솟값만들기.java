package algorithms.programmers.coding_all_problem.level2;

import java.util.Arrays;

public class 최솟값만들기 {

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);     // A를 오름차순 정렬
        Arrays.sort(B);     // B를 오름차순 정렬

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }

        return answer;
    }

    public static void main(String[] args) {

        int []A = {1, 4, 2};
        int []B = {5, 4, 4};

        최솟값만들기 solution = new 최솟값만들기();
        System.out.println(solution.solution(A, B));
    }
}
