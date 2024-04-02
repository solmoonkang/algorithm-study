package programmers.기초문제.day22;

import java.util.ArrayList;
import java.util.Arrays;

public class 배열의원소삭제하기 {

    public int[] solution(int[] arr, int[] delete_list) {

        // arr 의 원소 중 delete_list 의 원소를 모두 삭제하고, 남은 원소들은 기존의 arr 에 있던 순서를 유지한 배열을 반환하라

        ArrayList<Integer> list = new ArrayList<>();

        for (int a : arr) {

            list.add(a);

        }

        for (int i = 0; i < delete_list.length; i++) {

            if (list.contains(delete_list[i])) {

                list.remove(list.indexOf(delete_list[i]));

            }
        }

        int[] answer = list.stream().mapToInt(o -> o).toArray();

        return answer;
    }

    public static void main(String[] args) {

        배열의원소삭제하기 remove = new 배열의원소삭제하기();

        int[] arr1 = {293, 1000, 395, 678, 94};
        int[] arr2 = {110, 66, 439, 785, 1};

        int[] delete_list1 = {94, 777, 104, 1000, 1, 12};
        int[] delete_list2 = {377, 823, 119, 43};

        System.out.println("Result : " + Arrays.toString(remove.solution(arr1, delete_list1)));
        System.out.println("Result : " + Arrays.toString(remove.solution(arr2, delete_list2)));
    }
}
