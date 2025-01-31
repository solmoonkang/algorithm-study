package 모든문제.level1.전체문제;

public class 소수찾기 {

    public int solution(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        소수찾기 findPrime = new 소수찾기();

        System.out.println("findPrime = " + findPrime.solution(10));
        System.out.println("findPrime = " + findPrime.solution(5));
    }
}
