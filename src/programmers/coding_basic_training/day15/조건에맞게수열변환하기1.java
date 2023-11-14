package programmers.coding_basic_training.day15;

import java.util.Arrays;

public class 조건에맞게수열변환하기1 {

    public int[] solution_my(int[] arr) {

        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= 50 && arr[i] % 2 == 0) {

                answer[i] = arr[i] / 2;

            } else if (arr[i] < 50 && arr[i] % 2 != 0) {

                answer[i] = arr[i] * 2;

            } else {

                answer[i] = arr[i];
            }
        }

        return answer;
    }

    public int[] solution_best(int[] arr) {

        return Arrays.stream(arr)
                .map(operand -> operand >= 50 && operand % 2 == 0 ? operand / 2 : operand < 50 && operand % 2 == 1 ? operand * 2 : operand)
                .toArray();
    }

    public static void main(String[] args) {

        조건에맞게수열변환하기1 condition = new 조건에맞게수열변환하기1();

        int[] arr = {1, 2, 3, 100, 99, 98};

        System.out.println("Result My : " + Arrays.toString(condition.solution_my(arr)));
        System.out.println("Result Best : " + Arrays.toString(condition.solution_best(arr)));
    }
}
