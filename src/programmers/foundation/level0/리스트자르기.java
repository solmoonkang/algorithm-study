package programmers.foundation.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 리스트자르기 {

    public int[] solution(int n, int[] slicer, int[] num_list) {

        List<Integer> list = new ArrayList<>();

        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        // 만약, n == 1 일 경우
        if (n == 1) {

            for (int i = 0; i < b + 1; i++) {

                // num_list 의 0번 인덱스부터 b번 인덱스까지
                list.add(num_list[i]);
            }

        // 만약, n == 2 일 경우
        } else if (n == 2) {

            for (int i = a; i < num_list.length; i++) {

                // num_list 의 a번 인덱스부터 마지막 인덱스까지
                list.add(num_list[i]);
            }

        // 만약, n == 3 일 경우
        } else if (n == 3) {

            for (int i = a; i < b + 1; i++) {

                // num_list 의 a번 인덱스부터 b번 인덱스까지
                list.add(num_list[i]);
            }


        // 만약, n == 4 일 경우
        } else if (n == 4) {

            for (int i = a; i < b + 1; i += c) {

                // num_list 의 a번 인덱스부터 b번 인덱스까지 c 간격으로
                list.add(num_list[i]);
            }
        }

        // List 를 int[] 형 배열로 변환 -> 즉, List<Integer> 형식의 List 를 int[] 형식의 배열로 변환
        int[] answer = list
                .stream()             // List 를 Stream 으로 변환
                .mapToInt(x -> x)     // 각 요소를 int 로 변환, (x -> x) 는 요소를 그대로 반환하는 역할
                .toArray();           // Stream 에서 처리된 요소들을 int[] 배열로 변환하여 반환

        return answer;
    }

    public static void main(String[] args) {

        리스트자르기 cutList = new 리스트자르기();

        int[] slicer = {1, 5, 2};

        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Result : " + Arrays.toString(cutList.solution(3, slicer, num_list)));
        System.out.println("Result : " + Arrays.toString(cutList.solution(4, slicer, num_list)));
    }
}
