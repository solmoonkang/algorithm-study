package programmers.foundation.level0.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 원소들의곱과합 {

    public int solution(int[] num_list) {

        int multiple = 1;
        int square = 0;
        int answer = 0;

        for (int i = 0; i < num_list.length; i++) {

            multiple *= num_list[i];
        }

        for (int i = 0; i < num_list.length; i++) {

            answer += num_list[i];

            square = answer * answer;
        }

        return (multiple < square) ? 1 : 0;
    }

    public static void main(String[] args) {

        원소들의곱과합 element = new 원소들의곱과합();

        int[] num_list1 = {3, 4, 5, 2, 1};
        int[] num_list2 = {5, 7, 8, 3};

        System.out.println("Result : " + element.solution(num_list1));
        System.out.println("Result : " + element.solution(num_list2));
    }
}
