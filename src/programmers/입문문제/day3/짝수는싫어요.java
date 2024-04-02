package programmers.입문문제.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 짝수는싫어요 {

    /**
     * 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 반환하라
     */
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i+=2) {
            list.add(i);
        }
        int[] answer = list.stream().mapToInt(o -> o).toArray();
        return answer;
    }

    public static void main(String[] args) {
        짝수는싫어요 hateEven = new 짝수는싫어요();
        System.out.println("Result: " + Arrays.toString(hateEven.solution(10)));
        System.out.println("Result: " + Arrays.toString(hateEven.solution(15)));
    }
}
