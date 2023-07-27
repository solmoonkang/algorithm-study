package programmers.foundation.level0.list;

import java.util.Arrays;

public class 카운트다운 {

    public int[] solution(int start, int end) {

        int[] answer = new int[start - end + 1];

        // start 부터 end 까지 역순으로 순회하는 for 문으로, i가 end 와 같거나 작아질 때까지 실행
        for (int i = start; i >= end; i--) {

            // 현재 순회 중인 정수 i를 배열 answer 에 저장
            // 이 때, 인덱스는 start - i 로 계산하여 값을 저장할 위치를 지정

            // EX) start = 10, i = 10 일 경우, answer[10 - 10] = 10; 이므로 answer[0] = 10;
            answer[start - i] = i;

            // answer[i] = start - i;
        }

        return answer;
    }

    public static void main(String[] args) {

        카운트다운 countDown = new 카운트다운();

        System.out.println("Result : " + Arrays.toString(countDown.solution(10, 3)));
    }
}
