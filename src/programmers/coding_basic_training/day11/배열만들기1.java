package programmers.coding_basic_training.day11;

import java.util.ArrayList;
import java.util.Arrays;

public class 배열만들기1 {

    public int[] solution(int n, int k) {

        // 1 이상 n 이하 정수 중에서 k의 배수를 오름차순으로 저장한 배열을 반환하라

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = k; i <= n; i += k) {

            list.add(i);
        }

        int[] answer = list.stream().mapToInt(o -> o).toArray();

        return answer;
    }

    public static void main(String[] args) {

        배열만들기1 make = new 배열만들기1();

        System.out.println("Result : " + Arrays.toString(make.solution(10, 3)));
        System.out.println("Result : " + Arrays.toString(make.solution(15, 5)));
    }
}
