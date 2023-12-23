package algorithms.programmers.coding_all_problem.level1.practice_problems;

public class 콜라츠추측 {

    /**
     * [ 문제 설명 ]
     * 1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다.
     * 1-1. 입력된 수가 짝수라면 2로 나눕니다.
     * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
     * 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
     *
     * 예를 들어, 주어진 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이 됩니다.
     * 위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요.
     * 단, 주어진 수가 1인 경우에는 0을, 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환해 주세요.
     */
    public int solution(int num) {
        int count = 0;
        // 입력값이 int 범위를 초과할 수 있는 문제가 발생할 수도 있다.
        // 즉, num 값이 int 범위를 초과하더라도 정확한 값을 얻을 수 있다.
        long n = (long) num;
        if (n == 1) {
            return 0;
        }

        while (n != 1) {
            if (count == 500) {
                return -1;
            }

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (n * 3) + 1;
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        콜라츠추측 collatzConjecture = new 콜라츠추측();
        System.out.println("Result: " + collatzConjecture.solution(6));
        System.out.println("Result: " + collatzConjecture.solution(16));
        System.out.println("Result: " + collatzConjecture.solution(626331));
    }
}
