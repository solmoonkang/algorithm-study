package algorithms.programmers.coding_all_problem.level1.practice_problems;

import java.util.Arrays;

public class 최대공약수와최소공배수 {

    /**
     * [ 문제 설명 ]
     * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
     * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
     * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
     */
    public int[] solution(int n, int m) {
        int a = n;
        int b = m;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return new int[]{a, n * m / a};
    }

    public static void main(String[] args) {
        최대공약수와최소공배수 gcdLcm = new 최대공약수와최소공배수();
        System.out.println("Result: " + Arrays.toString(gcdLcm.solution(3, 12)));
        System.out.println("Result: " + Arrays.toString(gcdLcm.solution(2, 5)));
    }
}
