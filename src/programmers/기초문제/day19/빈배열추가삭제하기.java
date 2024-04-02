package programmers.기초문제.day19;

import java.util.ArrayList;
import java.util.Arrays;

public class 빈배열추가삭제하기 {

    public int[] solution(int[] arr, boolean[] flag) {

        // 아무 원소도 들어있지 않은 빈 배열 X가 있습니다.
        // 길이가 같은 정수 배열 arr 과 boolean 배열 flag 가 매개변수로 주어질 때, flag 를 차례대로 순회하며,
        // flag[i]가 true 라면 X의 뒤에 arr[i]를 arr[i] × 2 번 추가하고,
        // flag[i]가 false 라면 X에서 마지막 arr[i]개의 원소를 제거한 뒤 X를 반환하라

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (flag[i]) {

                for (int j = 0; j < arr[i] * 2; j++) {

                    list.add(arr[i]);

                }
            }

            if (!flag[i]) {

                for (int j = 0; j < arr[i]; j++) {

                    list.remove(list.size() - 1);

                }
            }
        }

        int[] answer = list.stream().mapToInt(o -> o).toArray();

        return answer;
    }

    public static void main(String[] args) {

        빈배열추가삭제하기 empty = new 빈배열추가삭제하기();

        int[] arr = {3, 2, 4, 1, 3};
        boolean[] flag = {true, false, true, false, false};

        System.out.println("Result : " + Arrays.toString(empty.solution(arr, flag)));
    }
}
