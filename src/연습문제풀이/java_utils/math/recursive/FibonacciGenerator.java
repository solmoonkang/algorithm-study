package 연습문제풀이.java_utils.math.recursive;

public class FibonacciGenerator {

    public int generator(int n) {
        return fibonacci(n);
    }

    private int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        FibonacciGenerator fibonacci = new FibonacciGenerator();
        int N = 10;
        for (int i = 0; i < N; i++) {
            // 피보나치 수열은 N = (N - 1) + (N - 2)이 계속해서 나오도록 하는 수열이다.
            System.out.print(fibonacci.generator(i) + " ");
        }
    }
}
