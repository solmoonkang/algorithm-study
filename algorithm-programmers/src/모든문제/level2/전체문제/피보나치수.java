package 모든문제.level2.전체문제;

public class 피보나치수 {

    public int solution(int n) {
        // 시간 초과 발생: 피보나치 수를 재귀 함수로 계산하는 과정에서 발생
        return fibo(n) % 1234567;
    }

    private int fibo(int number) {
        if (number < 1) return 0;
        if (number < 2) return 1;
        return fibo(number - 1) + fibo(number - 2);
    }

    public int refactor(int n) {
        // 시간 초과 해결을 위해 중복 계산을 피하는 방법을 적용
        // 다이나믹 프로그래밍을 통해 바텀업 접근 방식으로 해결
        long[] fibo = new long[n + 1];

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }
        return (int) (fibo[n] % 1234567);
    }


    public static void main(String[] args) {
        피보나치수 fibonacci = new 피보나치수();

        System.out.println("fibonacci = " + fibonacci.solution(3));
        System.out.println("fibonacci = " + fibonacci.solution(5));

        System.out.println("fibonacci = " + fibonacci.refactor(3));
        System.out.println("fibonacci = " + fibonacci.refactor(5));
    }
}
