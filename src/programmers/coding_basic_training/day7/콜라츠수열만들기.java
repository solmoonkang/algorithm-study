package programmers.coding_basic_training.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 콜라츠수열만들기 {

    public int[] solution(int n) {

        List<Integer> list = new ArrayList<>();

        while (n != 1) {

            list.add(n);

            if (n % 2 == 0) {

                n = n / 2;
            } else {

                n = 3 * n + 1;
            }
        }

        list.add(1);

        int[] answer = list.stream().mapToInt(o -> o).toArray();

        return answer;
    }

    public static void main(String[] args) {

        콜라츠수열만들기 colats = new 콜라츠수열만들기();

        System.out.println("Result : " + Arrays.toString(colats.solution(10)));
    }
}
