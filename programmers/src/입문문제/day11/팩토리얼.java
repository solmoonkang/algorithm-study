package 입문문제.day11;

public class 팩토리얼 {

    /**
     * [ 문제 설명 ]
     * i팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다.
     * 예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다. 정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 반환하라.
     * i! ≤ n
     */
    private int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= 10; i++) {
            if (n >= factorial(i)) {
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        팩토리얼 factorialCalculator = new 팩토리얼();
        System.out.println("Result: " + factorialCalculator.solution(3628800));
        System.out.println("Result: " + factorialCalculator.solution(7));
    }
}
