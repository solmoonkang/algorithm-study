package programmers.coding_basic_training.day19;

import java.util.ArrayList;
import java.util.Arrays;

public class 배열만들기6 {

    public int[] solution(int[] arr) {

        // 0과 1로만 이루어진 정수 배열 arr 를 이용해서 새로운 배열 stk 배열을 만든다
        // i의 초기값을 0으로 설정하고, i가 arr 의 길이보다 작으면 아래의 과정을 반복한다
            // 만약, stk 이 비었다면, arr[i]를 stk 에 추가하고 i에 1을 더한다
            // stk 에 원소가 있고, stk 의 마지막 원소가 arr[i]와 같으면, stk 의 마지막 원소를 stk 에서 제거하고 i에 1을 더한다
            // stk 에 원소가 있는데 stk 의 마지막 원소가 arr[i]와 다르다면, stk 의 맨 마지막에 arr[i]를 추가하고 i에 1을 더한다
        // 위 작업을 마친 후, 만들어진 stk 배열을 반환하라
        // ( 단, 만약 빈 배열을 반환해야한다면, -1을 반환한다 )

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (list.isEmpty()) {

                list.add(arr[i]);
            } else {

                if (list.get(list.size() - 1).equals(arr[i])) {

                    list.remove(list.size() - 1);
                } else {

                    list.add(arr[i]);
                }
            }
        }

        int[] answer;

        if (list.isEmpty()) {

            return new int[]{-1};
        } else {

         answer = list.stream().mapToInt(o -> o).toArray();

         return answer;
        }
    }

    public static void main(String[] args) {

        배열만들기6 make = new 배열만들기6();

        int[] arr1 = {0, 1, 1, 1, 0};
        int[] arr2 = {0, 1, 0, 1, 0};
        int[] arr3 = {0, 1, 1, 0};

        System.out.println("Result : " + Arrays.toString(make.solution(arr1)));
        System.out.println("Result : " + Arrays.toString(make.solution(arr2)));
        System.out.println("Result : " + Arrays.toString(make.solution(arr3)));
    }
}
