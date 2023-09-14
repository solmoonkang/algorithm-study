package programmers.coding_basic_training.level0.practice;

import java.util.ArrayList;
import java.util.List;

public class 정수찾기 {

    public int solution(int[] num_list, int n) {

        List<Integer> list = new ArrayList<>();

        int answer = 0;

        for (int i = 0; i < num_list.length; i++) {

            list.add(num_list[i]);

            if (list.contains(n)) {

                answer = 1;
            } else {

                answer = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        정수찾기 number = new 정수찾기();

        int[] num_list1 = {1, 2, 3, 4, 5};
        int[] num_list2 = {15, 98, 23, 2, 15};

        System.out.println("Result : " + number.solution(num_list1, 3));
        System.out.println("Result : " + number.solution(num_list2, 20));
    }
}
