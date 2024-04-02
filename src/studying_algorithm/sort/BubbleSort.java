package studying_algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] numbers = {3, 5, 1, 2, 4};
        int tempValue;

        for (int i = 0; i < numbers.length; i++) {

            // ( 0 - n ), ( 0 - n - 1 )번 반복을 돌면서 바로 옆 숫자와 비교
            for (int j = 0; j < numbers.length - i - 1; j++) {

                // 바로 우측 숫자와 비교하여 크기가 클 경우, 서로의 위치를 변경
                if (numbers[j] > numbers[j + 1]) {

                    tempValue = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tempValue;
                }
            }
        }

        System.out.println(Arrays.toString(numbers));
    }
}
