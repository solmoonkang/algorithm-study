package programmers.입문문제.day11;

public class 합성수찾기 {

    /**
     * [ 문제 설명 ]
     * 약수의 개수가 세 개 이상인 수를 합성수라고 합니다. 자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를 반환하라.
     * 어떤 수를 나누어 떨어지게 하는 수를 약수라고 한다. 예를 들어 6의 약수는 1, 2, 3, 6이다.
     */
    public int solution(int n) {
        int answer = 0;

        // 4보다 작은 수는 합성수가 될 수 없다.
        for (int i = 4; i <= n; i++) {
            int divisorCount = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisorCount++;
                }
            }
            if (divisorCount >= 3) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        합성수찾기 compositeNumberFinder = new 합성수찾기();
        System.out.println("Result: " + compositeNumberFinder.solution(10));
        System.out.println("Result: " + compositeNumberFinder.solution(15));
    }
}
