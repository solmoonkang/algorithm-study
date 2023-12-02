package algorithms.algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] numbers = {3, 5, 1, 2, 4};    // 숫자 배열
        int tempValue;  // 임시 저장공간
        int minIndex = 0;   // 최소값의 인덱스를 저장

        // 배열의 처음부터 끝까지 반복 ( currentIndex 는 현재 위치 )
        for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {

            // 제일 작은 수를 찾기 위해, minNumber 변수는 int 의 최대값으로 임시 저장
            int minNumber = Integer.MAX_VALUE;

            for (int j = currentIndex; j < numbers.length; j++) {

                // 현재 위치부터 배열의 마지막까지 반복문을 돌면서, 최소값을 계속해서 탐색
                if (numbers[j] < minNumber) {

                    minNumber = numbers[j]; // 찾은 촤소값을 업데이트
                    minIndex = j;           // 그 때의 인덱스를 업데이트
                }
            }

            // 찾은 최소값과 현재 위치의 값과 서로 변경
            tempValue = numbers[currentIndex];
            numbers[currentIndex] = numbers[minIndex];
            numbers[minIndex] = tempValue;
        }

        System.out.println(Arrays.toString(numbers));
    }
}
