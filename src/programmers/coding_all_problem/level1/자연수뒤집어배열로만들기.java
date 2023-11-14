package programmers.coding_all_problem.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {

    /**
     * 자연수 n 을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
     * 예를 들어, n 이 12345이면, [5, 4, 3, 2, 1] 을 리턴합니다.
     */

    public int[] solution_arrayList(long n) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        // n 이 0 이면, 더 이상의 자릿수가 없다는 의미이다
        while (n > 0) {

            // 현재 자릿수 추출한다, 예를 들면, 12345 일 경우, 1, 2, 3, 4, 5 의 형식으로 분리한다
            int currentNum = (int) (n % 10);

            // 현재 자릿수를 arrayList 에 저장한다
            arrayList.add(currentNum);

            // n 의 일의 자리가 삭제되고, 각 자리의 숫자가 오른쪽에서 왼쪽으로 이동하게 된다
            n /= 10;    // 즉, n 을 10 으로 나눈 몫으로 업데이트
        }

        int[] answer = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        자연수뒤집어배열로만들기 reverse = new 자연수뒤집어배열로만들기();

        System.out.println("Answer : " + Arrays.toString(reverse.solution_arrayList(123456789)));
    }
}
