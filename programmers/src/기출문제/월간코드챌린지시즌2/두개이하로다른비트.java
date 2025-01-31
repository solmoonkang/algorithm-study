package 기출문제.월간코드챌린지시즌2;

import java.util.Arrays;

public class 두개이하로다른비트 {

    /**
     * [ 문제 설명 ]
     * 양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.
     *
     * x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
     * 예를 들어,
     *
     *  - f(2) = 3 입니다. 다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
     * 수	비트	다른 비트의 개수
     * 2	000...0010
     * 3	000...0011	1
     *
     *  - f(7) = 11 입니다. 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.
     * 수	비트	다른 비트의 개수
     * 7	000...0111
     * 8	000...1000	4
     * 9	000...1001	3
     * 10	000...1010	3
     * 11	000...1011	2
     * 정수들이 담긴 배열 numbers가 매개변수로 주어집니다.
     * numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ numbers의 길이 ≤ 100,000
     * 0 ≤ numbers의 모든 수 ≤ 10^15
     */
    public long[] solution(long[] numbers) {
        // TODO: 비트 연산을 많이 사용하지 않아서 생소했음. 공부를 하고서 다시 풀어보자.
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            // 짝수인 경우, 가장 낮은 비트를 1로 바꾸기만 하면 된다.
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            // 홀수인 경우, 가장 낮은 0 비트를 찾아서 1로 바꾸고, 바로 위 비트를 0으로 바꿔야 한다.
            } else {
                long lastZero = ~numbers[i] & (numbers[i] + 1);
                long nexNumber = numbers[i] | lastZero;
                answer[i] = nexNumber ^ (lastZero >> 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        두개이하로다른비트 twoOfFewerDifferingBits = new 두개이하로다른비트();

        long[] numbers = {2, 7};
        System.out.println("twoOfFewerDifferingBits = " +
                Arrays.toString(twoOfFewerDifferingBits.solution(numbers)));
    }
}
