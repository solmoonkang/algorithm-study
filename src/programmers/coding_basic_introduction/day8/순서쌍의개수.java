package programmers.coding_basic_introduction.day8;

public class 순서쌍의개수 {

    /**
     * 순서쌍이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기합니다.
     * 자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 반환하라.
     */
    public int solution(int n) {
        // n으로 나눴을 때 나머지가 0인 값들
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        순서쌍의개수 numberOfOrderedPairs = new 순서쌍의개수();
        System.out.println("Result: " + numberOfOrderedPairs.solution(20));
        System.out.println("Result: " + numberOfOrderedPairs.solution(100));
    }
}
