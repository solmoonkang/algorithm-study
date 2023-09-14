package programmers.coding_basic_training.level0.practice;

import java.util.Arrays;

public class n번째원소부터 {

    // Runtime Error
    public int[] solution_array(int[] num_list, int n) {

//        int[] answer = {};
//
//        answer = Arrays.copyOfRange(num_list, 0, n);
//
//        return answer;

        int[] answer = new int[num_list.length - n + 1];

        for (int i = 0; i < num_list.length - n + 1; i++) {

            answer[i] = num_list[i + n - 1];
        }

        return answer;
    }

    public static void main(String[] args) {

        n번째원소부터 element = new n번째원소부터();

        int[] num_list1 = {2, 1, 6};
        int[] num_list2 = {5, 2, 1, 7, 5};

        System.out.println("Result : " + Arrays.toString(element.solution_array(num_list1, 1)));
        System.out.println("Result : " + Arrays.toString(element.solution_array(num_list2, 3)));
    }
}
