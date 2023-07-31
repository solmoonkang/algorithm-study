package algorithm.sort;

import java.util.Arrays;

public class Selection {

    /**
     * 선택 정렬 문제
     * 데이터가 무작위로 여러 개가 있다고 가정하고,
     * 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고, 그 다음 작은 데이터를 선택해 앞에서 두 번째 데이터와 바꾸는 과정을 반복한다
     *
     */

    public static void main(String[] args) {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        int minIndex = 0;       // 가장 작은 원소의 인덱스

        // 배열 arr 의 처음부터 끝까지 실행되는 외부 루프, 해당 루프가 한 번 반복할 때마다 배열의 가장 작은 값이 찾아져서 해당 위치로 교환
        for (int i = 0; i < arr.length; i++) {

            // 내부 루프로, 현재 위치 i 다음부터 배열의 끝까지 실행되고 해당 루프는 현재 위치보다 더 작은 값을 찾기 위해 사용
            for (int j = i + 1; j < arr.length; j++) {

                // 현재 최소 인덱스 minIndex 에 저장된 값이 해당 인덱스보다 큰 경우, 이를 업데이트하는데 사용
                if (arr[minIndex] > arr[j]) {

                    minIndex = j;
                }
            }

            // Swap
            int tmp = arr[i];

            arr[i] = arr[minIndex];

            arr[minIndex] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
