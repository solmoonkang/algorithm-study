package algorithms.programmers.coding_basic_introduction.day2;

import java.util.Arrays;

public class 분수의덧셈 {

    /**
     * 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
     * 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 반환하라
     */
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // TODO: 최대공약수가 무엇인지, 최대공약수를 구하는 방식에 대한 공부가 필요하다.
        int number = (numer1 * denom2) + (numer2 * denom1); // 분자
        int denom = denom1 * denom2;                        // 분모
        int max = 1;

        // denom과 number의 최대공약수를 찾아서 각각 나눠주면 된다.
        for (int i = 1; i <= number && i <= denom; i++) {
            if (number % i == 0 && denom % i == 0) {
                max = i;
            }
        }

        number = number / max;
        denom = denom / max;

        int[] answer = {number, denom};
        return answer;
    }

    public static void main(String[] args) {
        분수의덧셈 sum = new 분수의덧셈();
        System.out.println("Result: " + Arrays.toString(sum.solution(1, 2, 3, 4)));
        System.out.println("Result: " + Arrays.toString(sum.solution(9, 2, 1, 3)));
    }
}
