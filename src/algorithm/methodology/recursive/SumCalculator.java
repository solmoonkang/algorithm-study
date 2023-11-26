package algorithm.methodology.recursive;

public class SumCalculator {

    public int calculator(int n) {
        return recursive(n);
    }

    private int recursive(int n) {
        if (n == 0) {
            return 0;
        }
        return n += recursive(n - 1);
    }

    public static void main(String[] args) {
        SumCalculator sum = new SumCalculator();
        int N = 5;
        System.out.println("1부터 " + N + "까지의 합계는 " + sum.calculator(N) + "입니다.");
    }
}
