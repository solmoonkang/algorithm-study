package 기초문제.day20;

import java.util.Arrays;

public class 뒤에서5등까지 {

    public int[] solution(int[] num_list) {

        // num_list 에서 가장 작은 5개의 수를 오름차순으로 담은 리스트를 반환하라

        Arrays.sort(num_list);

        int[] answer = new int[5];

        for (int i = 0; i < answer.length; i++) {

            answer[i] = num_list[i];

        }

        return answer;
    }

    public int[] other(int[] num_list) {

        return Arrays.stream(num_list).sorted().limit(5).toArray();

    }

    public static void main(String[] args) {

        뒤에서5등까지 five = new 뒤에서5등까지();

        int[] num_list = {12, 4, 15, 46, 38, 1, 14};

        System.out.println("Result : " + Arrays.toString(five.solution(num_list)));
    }
}
