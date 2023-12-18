package algorithms.programmers.coding_all_problem.level1.codechallenge2;

public class 음양더하기 {

    /**
     * [ 문제 설명 ]
     * 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다.
     * 실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 조건 ]
     * absolutes의 길이는 1 이상 1,000 이하입니다.
     * absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
     * signs의 길이는 absolutes의 길이와 같습니다.
     * signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.
     */
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        음양더하기 addPositiveNegative = new 음양더하기();
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};
        System.out.println("Result: " + addPositiveNegative.solution(absolutes, signs));
    }
}
