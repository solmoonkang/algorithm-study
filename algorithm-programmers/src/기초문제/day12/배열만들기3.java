package 기초문제.day12;

import java.util.ArrayList;
import java.util.Arrays;

public class 배열만들기3 {

    public int[] solution(int[] arr, int[][] intervals) {

        // intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 각 구간은 닫힌 구간입니다.
        // 닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미합니다.
        // 이때 배열 arr의 첫 번째 구간에 해당하는 배열과 두 번째 구간에 해당하는 배열을 앞뒤로 붙여 새로운 배열을 만들어 반환하라

        // intervals 의 a~b 구간에 해당하는 arr 배열을 리스트에 추가한다

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {

                list.add(arr[j]);
            }
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {

        배열만들기3 createArray3 = new 배열만들기3();

        int[] arr = {1, 2, 3, 4, 5};
        int[][] intervals = {{1, 3}, {0, 4}};

        System.out.println("Result : " + Arrays.toString(createArray3.solution(arr, intervals)));
    }
}
