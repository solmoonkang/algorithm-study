package codingTest.level0;

import java.util.Arrays;

public class n번째원소부터 {

    public int[] solution_array(int[] num_list, int n) {

        int[] answer = Arrays.copyOfRange(num_list, n - 1, num_list.length);

        return answer;
    }

    public int[] solution_list(int[] num_list, int n) {

        int[] answer = new int[num_list.length - n + 1];

        for (int i = n - 1; i < num_list.length; i++) {

            answer[i - n + 1] = num_list[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        n번째원소부터 element = new n번째원소부터();

        int[] num_list = {5, 2, 1, 7, 5};

        System.out.println("num_list : " + Arrays.toString(element.solution_array(num_list, 2)));
        System.out.println("num_list : " + Arrays.toString(element.solution_list(num_list, 2)));
    }
}
