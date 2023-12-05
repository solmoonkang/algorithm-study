package algorithms.programmers.coding_all_problem.level1;

public class 두정수사이의합 {

    /**
     * [ 문제 설명 ]
     * 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
     * 예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
     */
    public long solution(int a, int b) {
        long sum = 0;
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        if (start == end) {
            return start;
        }

        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        두정수사이의합 sumBetweenTwoNumbers = new 두정수사이의합();
        System.out.println("Result: " + sumBetweenTwoNumbers.solution(3, 5));
        System.out.println("Result: " + sumBetweenTwoNumbers.solution(3, 3));
        System.out.println("Result: " + sumBetweenTwoNumbers.solution(5, 3));
    }
}
