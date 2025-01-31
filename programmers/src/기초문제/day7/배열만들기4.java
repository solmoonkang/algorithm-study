package 기초문제.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열만들기4 {

    public int[] solution(int[] arr) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length;) {

            if (list.size() == 0) {

                list.add(arr[i]); i++;

            } else if (list.size() != 0 && list.get(list.size() - 1) < arr[i]) {

                list.add(arr[i]); i++;

            } else {

                list.remove(list.size() - 1);
            }
        }
        return list.stream().mapToInt(o -> o).toArray();
    }


    public static void main(String[] args) {

        배열만들기4 array = new 배열만들기4();

        int[] arr = {1, 4, 2, 5, 3};

        System.out.println("Result : " + Arrays.toString(array.solution(arr)));
    }
}
