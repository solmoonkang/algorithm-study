package algorithms.programmers.coding_basic_training.day19;

import java.util.Arrays;

public class 무작위로K개의수뽑기 {

    public int[] solution(int[] arr, int k) {

        // 랜덤으로 서로 다른 K개의 수를 저장한 배열을 만든다
        // 일정 범위 내에서 무작위로 수를 뽑은 후, 지금까지 나온적 없는 수는 배열 맨 뒤에 추가하는 방식으로 만든다
        // ( 단, 완성될 배열의 길이가 K보다 작으면, 나머지 값을 전부 -1로 채워서 반환하라 )

        int[] distinctArr = Arrays.stream(arr).distinct().toArray();

        int[] answer = new int[k];
        Arrays.fill(answer, -1);

        for (int i = 0; i < Math.min(distinctArr.length, k); i++) {

            answer[i] = distinctArr[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        무작위로K개의수뽑기 k = new 무작위로K개의수뽑기();

        int[] first_arr = {0, 1, 1, 2, 2, 3};
        int[] second_arr = {0, 1, 1, 1, 1};

        System.out.println("Result : " + Arrays.toString(k.solution(first_arr, 3)));
        System.out.println("Result : " + Arrays.toString(k.solution(second_arr, 4)));
    }
}
