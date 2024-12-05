package programmers.알고리즘고득점KIT.Dynamic;

import java.util.Arrays;

public class N으로표현 {

    private static final int MAX_NUMBER = 32000;

    // TODO: 문제가 정상적으로 동작하지 않는다. 점화식 부분을 다시 한 번 구현해보자.
    public int solution(int N, int number) {
        int[] dynamicArray = new int[MAX_NUMBER + 1];

        Arrays.fill(dynamicArray, 9);
        dynamicArray[0] = 0;
        dynamicArray[N] = 1;

        for (int k = 1; k <= 8; k++) {
            int currentN = 0;
            for (int j = 0; j < k; j++) {
                currentN = currentN * 10 + N;
            }

            if (currentN <= MAX_NUMBER) dynamicArray[currentN] = Math.min(dynamicArray[currentN], k);
        }

        for (int i = 1; i <= MAX_NUMBER; i++) {
            for (int j = 1; j < i; j++) {
                dynamicArray[i] = Math.min(dynamicArray[i], dynamicArray[j] + dynamicArray[i - j]);

                if (i % j == 0) dynamicArray[i] = Math.min(dynamicArray[i], dynamicArray[j] + dynamicArray[i / j]);
                if (i - j >= 0) dynamicArray[i] = Math.min(dynamicArray[i], dynamicArray[j] + dynamicArray[i - j]);
                if (j > 0 && i % j == 0) dynamicArray[i] = Math.min(dynamicArray[i], dynamicArray[j] + dynamicArray[i / j]);
            }
        }

        return (dynamicArray[number] > 8) ? -1 : dynamicArray[number];
    }

    public static void main(String[] args) {
        N으로표현 n = new N으로표현();
        System.out.println("Result: " + n.solution(5, 12));
        System.out.println("Result: " + n.solution(2, 11));
    }
}
