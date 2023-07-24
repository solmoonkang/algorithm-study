package codingTest.level0.day4;

import java.util.stream.IntStream;

public class 홀짝에따라다른값반환하기 {

    public int solution_my(int n) {

        // even 은 짝수면, n 이하의 값들 중 모든 짝수의 값을 다 더해서 반환
        int even = 0;

        // odd 는 홀수면, n 이하의 값들 중 모든 홀수의 값을 다 더해서 반환
        int odd = 0;

        for (int i = 0; i <= n; i++) {

            if (i % 2 == 0) {

                even += i * i;
            } else {

                odd += i;
            }
        }

        // n 이 짝수면 even 을 홀수면 odd 를 반환하도록
        int answer = (n % 2 == 0) ? even : odd;

        return answer;
    }

    public int solution_best(int n) {

        if (n % 2 == 0) {

            return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).map(i -> (int) Math.pow(i, 2)).sum();
        }

        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 1).sum();
    }

    public static void main(String[] args) {

        홀짝에따라다른값반환하기 result = new 홀짝에따라다른값반환하기();

        System.out.println("Result : " + result.solution_my(7));
        System.out.println("Result : " + result.solution_my(10));
        System.out.println("======================================");

        System.out.println("Result : " + result.solution_best(7));
        System.out.println("Result : " + result.solution_best(10));
    }
}
