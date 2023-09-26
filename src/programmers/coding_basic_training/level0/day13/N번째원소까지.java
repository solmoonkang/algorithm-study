package programmers.coding_basic_training.level0.day13;

import java.util.Arrays;

public class N번째원소까지 {

    public int[] solution(int[] num_list, int n) {

        // num_list 의 첫 번째 원소부터 N번째 원소까지의 모든 원소를 담은 리스트를 반환하라

        return Arrays.copyOfRange(num_list, 0, n);
    }

    public static void main(String[] args) {

        N번째원소까지 n = new N번째원소까지();

        int[] first_num_list = {2, 1, 6};
        int[] second_num_list = {5, 2, 1, 7, 5};

        System.out.println("Result : " + Arrays.toString(n.solution(first_num_list, 1)));
        System.out.println("Result : " + Arrays.toString(n.solution(second_num_list, 3)));
    }
}
