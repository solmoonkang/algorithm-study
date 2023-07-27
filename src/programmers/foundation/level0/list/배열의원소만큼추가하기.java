package programmers.foundation.level0.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열의원소만큼추가하기 {

    public int[] solution(int[] arr) {

        // Integer List 를 생성
        List<Integer> list = new ArrayList<>();

        // 입력한 배열 arr 의 모든 요소를 순회
        for (int i = 0; i < arr.length; i++) {

            // 현재 arr 의 요소 arr[i]가 주어질 때, arr[i]번 반복
            for (int j = 0; j < arr[i]; j++) {

                // list 에 현재 배열 요소 arr[i]를 추가
                // 이중 for 문이 끝날 땐, list 에는 arr 의 각 요소가 각각 요소의 값만큼 반복
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];

        // list 의 모든 요소를 순회
        for (int i = 0; i < list.size(); i++) {

            // answer 배열의 각 요소에 list 의 각 요소 값을 할당
            // 이럴 경우, answer 배열과 list 요소들이 동일한 순서대로 동일한 값을 갖음
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        배열의원소만큼추가하기 add = new 배열의원소만큼추가하기();

        int[] arr1 = {5, 1, 4};
        int[] arr2 = {6, 6};
        int[] arr3 = {1};

        System.out.println("Result : " + Arrays.toString(add.solution(arr1)));
        System.out.println("Result : " + Arrays.toString(add.solution(arr2)));
        System.out.println("Result : " + Arrays.toString(add.solution(arr3)));
    }
}
