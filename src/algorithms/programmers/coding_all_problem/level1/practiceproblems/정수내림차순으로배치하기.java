package algorithms.programmers.coding_all_problem.level1.practiceproblems;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {

    /**
     * [ 문제 설명 ]
     * 함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
     */
    public long solution(long n) {
        // 정수를 문자열로 변환하고, 문자 배열로 변환한다.
        char[] chars = String.valueOf(n).toCharArray();
        // 문자 배열을 오름차순으로 정렬한다.
        Arrays.sort(chars);
        // 배열을 뒤집어 내림차순으로 만들고, 문자열로 변환하고 다시 정수로 변환하여 반환한다.
        return Long.parseLong(new StringBuilder(new String(chars)).reverse().toString());
    }

    public static void main(String[] args) {
        정수내림차순으로배치하기 arrangeDescendingOrder = new 정수내림차순으로배치하기();
        System.out.println("Result: " + arrangeDescendingOrder.solution(118372));
    }
}
