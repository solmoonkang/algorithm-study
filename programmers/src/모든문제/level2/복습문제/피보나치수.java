package 모든문제.level2.복습문제;

public class 피보나치수 {

    public int solution(int n) {
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }

        return fibo[n];
    }

    public static void main(String[] args) {
        피보나치수 problem = new 피보나치수();

        System.out.println("problem = " + problem.solution(3));
        System.out.println("problem = " + problem.solution(5));
    }
}
