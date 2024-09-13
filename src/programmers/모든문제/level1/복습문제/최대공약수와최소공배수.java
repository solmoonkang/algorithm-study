package programmers.모든문제.level1.복습문제;

import java.util.Arrays;

public class 최대공약수와최소공배수 {

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
