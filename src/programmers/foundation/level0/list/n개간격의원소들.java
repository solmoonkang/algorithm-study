package programmers.foundation.level0.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n개간격의원소들 {

    public int[] solution(int[] num_list, int n) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num_list.length; i += n) {

            list.add(num_list[i]);
        }

        int[] answer = list.stream().mapToInt(x -> x).toArray();

        return answer;
    }

    public static void main(String[] args) {

        n개간격의원소들 element = new n개간격의원소들();

        int[] num_list = {4, 2, 6, 1, 7, 6};

        System.out.println("Result : " + Arrays.toString(element.solution(num_list, 2)));
        System.out.println("Result : " + Arrays.toString(element.solution(num_list, 4)));
    }
}
