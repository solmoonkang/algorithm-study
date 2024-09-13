package programmers.모든문제.level1.복습문제;

import java.util.Arrays;

public class 최대공약수와최소공배수 {

    /**
     * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
     * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
     * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
     */

    /**
     * 최대공약수: 서로 다른 두 자연수의 공통된 약수 중 가장 큰 자연수
     * 최소공배수: 서로 다른 두 자연수의 공통된 배수 중 가장 작은 자연수
     */

    public int[] solution(int n, int m) {
        int gcd = getGCD(n ,m);
        int lcm = (n * m) / gcd;

        return new int[]{gcd, lcm};
    }

    public int getGCD(int n, int m) {
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }

        return n;
    }

    public static void main(String[] args) {
        최대공약수와최소공배수 problem = new 최대공약수와최소공배수();

        System.out.println("problem = " + Arrays.toString(problem.solution(3, 12)));
        System.out.println("problem = " + Arrays.toString(problem.solution(2, 5)));
    }
}
