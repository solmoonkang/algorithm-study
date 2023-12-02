package algorithms.programmers.coding_basic_training.day13;

import java.util.ArrayList;
import java.util.Arrays;

public class 순서바꾸기 {

    public int[] solution(int[] num_list, int n) {

        // num_list를 n번째 원소 이후의 원소들과 n번째까지의 원소들로 나눠서,
        // n번째 원소 이후의 원소들을 n번째까지의 원소들 앞에 붙인 리스트를 반환하라

        // N번째 원소 이후랑 N번째 원소까지 리스트로 이어붙이면 된다

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = n; i < num_list.length; i++) {

            list.add(num_list[i]);
        }

        for (int i = 0; i < n; i++) {

            list.add(num_list[i]);
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {

        순서바꾸기 change = new 순서바꾸기();

        int[] first_num_list = {2, 1, 6};
        int[] second_num_list = {5, 2, 1, 7, 5};

        System.out.println("Result : " + Arrays.toString(change.solution(first_num_list, 1)));
        System.out.println("Result : " + Arrays.toString(change.solution(second_num_list, 3)));
    }
}
