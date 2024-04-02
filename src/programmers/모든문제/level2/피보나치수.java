package programmers.모든문제.level2;

public class 피보나치수 {

    /** Solution
     *  풀긴 했는데 Runtime Error 발생, 더 효율적인 방법을 찾아보자
     */

    public int solution(int n) {

        // 재귀함수로 풀어야하나...?

        // 피보나치 수는 F(n) = F(n - 1) + F(n - 2)가 적용되는 수이다
        // 2 이상의 N이 입력되었을 때, N번째 피보나치 수를 1234567로 나눈 나머지를 반환하라

        int answer = 0;

        if (n >= 2) {

            answer = fibonacci(n) % 1234567;

        }

        return answer;
    }

    private int fibonacci(int n) {

        int sum = 0;

        if (n > 1) {

            sum = fibonacci(n - 1) + fibonacci(n - 2);

        } else if (n == 1) {

            sum = 1;

        } else if (n == 0) {

            sum = 0;

        }

        return sum;
    }

    public static void main(String[] args) {

        피보나치수 fibonacci = new 피보나치수();

        System.out.println("Result : " + fibonacci.solution(3));
        System.out.println("Result : " + fibonacci.solution(5));
    }
}
