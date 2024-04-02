package programmers.입문문제.day5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 배열뒤집기 {

    /**
     * 정수가 들어 있는 배열 num_list가 매개변수로 주어집니다.
     * num_list의 원소의 순서를 거꾸로 뒤집은 배열을 반환하라.
     */
    public int[] stream_solution(int[] num_list) {
        return IntStream.rangeClosed(1, num_list.length)
                .map(n -> num_list[num_list.length - n])
                .toArray();
    }

    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];

        for (int i = num_list.length - 1; i >= 0; i--) {
            // 원본 배열의 i번째 요소를 대상 배열의 num_list.length - 1 - i번째 위치에 저장해야 한다.
            answer[num_list.length - 1 - i] = num_list[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        배열뒤집기 reverse = new 배열뒤집기();
        int[] firstNumList = {1, 2, 3, 4, 5};
        int[] secondNumList = {1, 1, 1, 1, 1, 2};
        int[] thirdNumList = {1, 0, 1, 1, 1, 3, 5};
        System.out.println("Result: " + Arrays.toString(reverse.solution(firstNumList)));
        System.out.println("Result: " + Arrays.toString(reverse.solution(secondNumList)));
        System.out.println("Result: " + Arrays.toString(reverse.solution(thirdNumList)));
    }
}
