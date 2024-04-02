package programmers.입문문제.day7;

public class 짝수의합 {

    /**
     * 정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 반환하라.
     */
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i += 2) {
            answer += i;
        }
        return answer;
    }

    public static void main(String[] args) {
        짝수의합 sumOfEvenNumber = new 짝수의합();
        System.out.println("Result: " + sumOfEvenNumber.solution(10));
        System.out.println("Result: " + sumOfEvenNumber.solution(4));
    }
}
