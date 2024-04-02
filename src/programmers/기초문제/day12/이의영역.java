package programmers.기초문제.day12;

import java.util.Arrays;

public class 이의영역 {

    public int[] solution(int[] arr) {

        // 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 반환하라
        // ( 단, 배열에 2가 없는 경우 -1을 반환하라 )

        int start = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 2) {

                start = i;

                break;
            }
        }

        int end = -1;

        if (start == -1) {

            return new int[]{-1};

        } else {

            for (int i = arr.length - 1; i >= start; i--) {

                if (arr[i] == 2) {

                    end = i;

                    break;
                }
            }
        }

        return Arrays.copyOfRange(arr, start, end + 1);
    }

    public static void main(String[] args) {

        이의영역 s = new 이의영역();

        int[] arr = {1, 2, 1, 4, 5, 2, 9};

        System.out.println("Result : " + Arrays.toString(s.solution(arr)));
    }
}
