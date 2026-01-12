package 기초문제.day12;

import java.util.Arrays;

public class 배열조각하기 {

    public int[] solution(int[] arr, int[] query) {

        // query를 순회하면서 다음 작업을 반복한다
            // 짝수 인덱스에서는 arr에서 query[i]번 인덱스를 제외하고, 배열의 query[i]번 인덱스 뒷부분을 잘라서 버린다
            // 홀수 인덱스에서는 arr에서 query[i]번 인덱스는 제외하고, 배열의 query[i]번 인덱스 앞부분을 잘라서 버린다
        // 위 작업을 마친 후, 남은 arr의 부분 배열을 반환하라

        // query의 요소들을 이용해서 arr의 인덱스 값에 접근한다
        // 해당 값이 짝수이면 뒷부분을 잘라서 버리고, 홀수이면 앞부분을 잘라서 버린다
        // query 배열을 전부 다 순회하면, 해당 arr배열을 반환한다

        int[] answer = arr;

        for (int i = 0; i < query.length; i++) {

            if (i % 2 == 0) {

                answer = Arrays.copyOfRange(answer, 0, query[i] + 1);

            } else {

                answer = Arrays.copyOfRange(answer, query[i], answer.length);

            }
        }

        return answer;
    }

    public static void main(String[] args) {

        배열조각하기 carving = new 배열조각하기();

        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};

        System.out.println("Result : " + Arrays.toString(carving.solution(arr, query)));
    }
}
