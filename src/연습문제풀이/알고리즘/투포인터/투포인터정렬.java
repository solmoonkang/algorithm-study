package 연습문제풀이.알고리즘.투포인터;

import java.util.Arrays;

public class 투포인터정렬 {

    /**
     * 투 포인터 정렬
     * 정렬된 두 개의 배열이나 리스트를 병합하는 문제에서 사용된다.
     * 투 포인터를 사용하여 정렬된 두 배열을 한 번에 비교하고, 작은 값을 새로운 배열에 추가하는 방식으로 문제를 해결할 수 있다.
     *
     * 예를 들어, 정렬된 두 배열을 한 번에 비교하고, 작은 값을 새로운 배열에 추가하는 문제이다.
     * 1. merged 라는 number1 배열과 number2 배열을 합친 새로운 배열을 구성한다.
     * 2. i 와 j 포인터를 사용하여 numbers1과 numbers2 배열을 하나씩 비교하여 i 와 j가 더 작은 경우 해당 반복문을 종료한다.
     * 3-1. numbers2 배열의 값이 더 큰 경우: merged 배열에 number1 값을 넣고 i를 증가시킨다.
     * 3-2. numbers1 배열의 값이 더 큰 경우: merged 배열에 number2 값을 넣고 j를 증가시킨다.
     * 4. 한 번의 루프가 종료될 때 K 값을 증가시킨다.
     * 5. i가 number1의 길이보다 작으면 number1의 나머지 요소들은 merged에 할당하고 i와 k를 증가시킨다.
     * 6. j가 number2의 길이보다 작으면 number2의 나머지 요소들은 merged에 할당하고 j와 k를 증가시킨다.
     */
    public int[] solution(int[] numbers1, int[] numbers2) {
        // 1. merged라는 number1 배열과 number2 배열을 합친 새로운 배열을 구성한다.
        int[] merged = new int[numbers1.length + numbers2.length];
        int i = 0, j = 0, k = 0;

        // 2. i와 j 포인터를 사용하여 numbers1과 numbers2 배열을 하나씩 비교하여 i와 j가 더 작은 경우 해당 반복문이 종료된다.
        while (i < numbers1.length && j < numbers2.length) {

            // 3-1. numbers2 배열의 값이 더 큰 경우: merged 배열에 number1 값을 넣고 i를 증가시킨다.
            if (numbers1[i] < numbers2[j]) {
                merged[k] = numbers1[i];
                i++;
            }

            // 3-2. numbers1 배열의 값이 더 큰 경우: merged 배열에 number2 값을 넣고 j를 증가시킨다.
            else {
                merged[k] = numbers2[j];
                j++;
            }

            // 4. 한 번의 루프가 종료될 때 K 값을 증가시킨다.
            k++;
        }

        // 5. i가 number1의 길이보다 작으면 number1의 나머지 요소들은 merged에 할당하고 i와 k를 증가시킨다.
        while (i < numbers1.length) {
            merged[k] = numbers1[i];
            i++;
            k++;
        }

        // 6. j가 number2의 길이보다 작으면 number2의 나머지 요소들은 merged에 할당하고 j와 k를 증가시킨다.
        while (j < numbers2.length) {
            merged[k] = numbers2[j];
            j++;
            k++;
        }

        return merged;
    }

    public static void main(String[] args) {
        투포인터정렬 twoPointerSort = new 투포인터정렬();

        int[] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] numbers2 = {10, 11, 18, 13, 14, 15};
        System.out.println("twoPointerSort = " +
                Arrays.toString(twoPointerSort.solution(numbers1, numbers2)));
    }
}
