package programmers.foundation.level0.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class 카운트업 {

    public int[] solution(int start, int end) {

        int[] answer = new int[end - start + 1];

        for (int i = 0; i < answer.length; i++) {

            answer[i] = start;

            start++;
        }

        return answer;
    }

    public List solution_arraylist(int start, int end) {

        List<Integer> list = new ArrayList<>();

        for (int i = start; i <= end; i++) {

            list.add(i);
        }

        return list;
    }

    public int[] solution_best(int start, int end) {

        return IntStream.rangeClosed(start, end).toArray();
    }

    public static void main(String[] args) {

        카운트업 countUp = new 카운트업();

        System.out.println("Result : " + Arrays.toString(countUp.solution(3, 10)));
        System.out.println("Result : " + (countUp.solution_arraylist(3, 10)));
    }
}
