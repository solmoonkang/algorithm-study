package 모든문제.level0.코딩테스트입문;

import java.util.Arrays;

public class 연속된수의합 {

    // TODO: x를 계산하는 방법에서 헷갈려서 시간이 소요됨.
    public int[] solution(int num, int total) {
        int firstNum = (num - 1) * num / 2;     // 0부터 (num - 1)까지의 합
        int x = (total - firstNum) / num;       // x의 값 계산

        int[] answer = new int[num];

        for (int i = 0; i < num; i++) {
            answer[i] = x + i;
        }

        return answer;
    }

    public static void main(String[] args) {
        연속된수의합 sumOfConsecutiveNumbers = new 연속된수의합();

        System.out.println("sumOfConsecutiveNumbers = " + Arrays.toString(sumOfConsecutiveNumbers.solution(3, 12)));
        System.out.println("sumOfConsecutiveNumbers = " + Arrays.toString(sumOfConsecutiveNumbers.solution(5, 15)));
        System.out.println("sumOfConsecutiveNumbers = " + Arrays.toString(sumOfConsecutiveNumbers.solution(4, 14)));
        System.out.println("sumOfConsecutiveNumbers = " + Arrays.toString(sumOfConsecutiveNumbers.solution(5, 5)));
    }
}
