package programmers.foundation.level0.list;

import java.util.Arrays;

public class 배열만들기1 {

    public int[] solution(int n, int k) {

        int[] answer = new int[n / k];

        for (int i = k; i <= n + 1; i++) {

            answer[i] = i;
        }

        return answer;
    }

    public static void main(String[] args) {

        배열만들기1 array = new 배열만들기1();

        System.out.println("Array : " + Arrays.toString(array.solution(10, 3)));
        System.out.println("Array : " + Arrays.toString(array.solution(15, 5)));
    }
}
