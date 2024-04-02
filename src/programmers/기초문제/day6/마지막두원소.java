package programmers.기초문제.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 마지막두원소 {

    public int[] solution(int[] num_list) {

        List<Integer> list = new ArrayList<>();

        // 배열 num_list 를 리스트에 할당
        for (int num : num_list) {

            list.add(num);
        }

        // 만약, 마지막 원소가 그전 원소보다 크면,
        if (list.get(list.size() - 1) > list.get(list.size() - 2)) {
            // 마지막 원소에서 그전 원소를 뺀 값을 마지막 원소로 추가
            list.add(list.get(list.size() - 1) - list.get(list.size() - 2));
        }

        // 만약, 마지막 원소가 그전 원소보다 작으면,
        else {
            // 마지막 원소를 두 배한 값을 마지막 원소로 추가
            list.add(list.get(list.size() - 1) * 2);
        }

        int[] answer = list.stream().mapToInt(o -> o).toArray();

        return answer;
    }

    public static void main(String[] args) {

        마지막두원소 element = new 마지막두원소();

        int[] num_list = {2, 1, 6};
        int[] num_list2 = {5, 2, 1, 7, 5};

        System.out.println("Result : " + Arrays.toString(element.solution(num_list)));
        System.out.println("Result : " + Arrays.toString(element.solution(num_list2)));
    }
}
