package programmers.coding_basic_introduction.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 중앙값구하기 {

    /**
     * 중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다.
     * 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다. 정수 배열 array가 매개변수로 주어질 때, 중앙값을 반환하라
     */
    public int solution(int[] array) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        Arrays.sort(array);

        for (int i = 0; i < (array.length + 1) / 2; i++) {
            list.add(array[i]);
            answer = list.get(list.size() - 1);
        }

        return answer;
     }

    public static void main(String[] args) {
        중앙값구하기 middle = new 중앙값구하기();
        int[] firstArray = {1, 2, 7, 10, 11};
        int[] secondArray = {9, -1, 0};
        System.out.println("Result: " + middle.solution(firstArray));
        System.out.println("Result: " + middle.solution(secondArray));
    }
}