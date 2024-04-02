package programmers.기초문제.day21;

import java.util.Arrays;

public class 뒤에서5등위로 {

    public int[] solution(int[] num_list) {

        // num_list 에서 가장 작은 5개의 수를 제외한 수들을 오름차순으로 담은 리스트를 반환하라

        Arrays.sort(num_list);

        int[] answer = new int[num_list.length - 5];

        System.arraycopy(num_list, 5, answer, 0, num_list.length - 5);

        return answer;
    }

    public static void main(String[] args) {

        뒤에서5등위로 five = new 뒤에서5등위로();

        int[] num_list = {12, 4, 15, 46, 38, 1, 14, 56, 32, 10};

        System.out.println("Result : " + Arrays.toString(five.solution(num_list)));
    }
}
