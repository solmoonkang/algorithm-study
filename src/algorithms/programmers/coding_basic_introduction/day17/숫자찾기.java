package algorithms.programmers.coding_basic_introduction.day17;

public class 숫자찾기 {

    /**
     * [ 문제 설명 ]
     * 정수 num과 k가 매개변수로 주어질 때,
     * num을 이루는 숫자 중에 k가 있으면 num의 그 숫자가 있는 자리 수를 return하고 없으면 -1을 반환하라.
     */
    public int solution(int num, int k) {
        int answer = 0;
        String s = String.valueOf(num);
        for (char c : s.toCharArray()) {
            if (Character.getNumericValue(c) == k) {
                answer = s.indexOf(Character.toString(c)) + 1;
                break;
            }
        }
        return answer == 0 ? -1 : answer;
    }

    public static void main(String[] args) {
        // TODO: commit: Implement find the number in coding test beginner
        숫자찾기 findNumber = new 숫자찾기();
        System.out.println("Result: " + findNumber.solution(29183, 1));
        System.out.println("Result: " + findNumber.solution(232443, 4));
        System.out.println("Result: " + findNumber.solution(123456, 7));
    }
}
