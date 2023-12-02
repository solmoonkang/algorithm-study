package algorithms.programmers.coding_basic_training.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열만들기2 {

    public int[] solution(int l, int r) {

        List<Integer> list = new ArrayList<>();

        for (int i = l; i <= r; i++) {

            // 정수 i를 문자열 s로 변환
            String s = i + "";
            // 각 숫자의 0과 5의 개수를 저장하기 위한 count 변수를 초기화
            int count = 0;

            // 문자열 s의 길이만큼 반복문을 수행하여 각 자릿수를 확인
            for (int j = 0; j < s.length(); j++) {
                // 만약, 문자열 s의 j번째 문자가 '0'(ASCII 코드 48) 또는 '5'(ASCII 코드 53) 인 경우,
                // 혹은 문자 리털 '0'과 '5'를 직접 비교하는 경우,
                if (s.charAt(j) == '0' || s.charAt(j) == '5') {
                    // count 값을 증가
                    count++;
                }
            }
            // 모든 문자가 확인된 후,
            // 만약, count 가 문자열 s의 길이와 같을 경우, ( i가 0과 5로만 이루어진 정수이므로 )
            if (count == s.length()) {
                // 리스트에 추가
                list.add(i);
            }
        }

        int[] answer = list.stream().mapToInt(o -> o).toArray();
        int[] empty = {-1};

        if (answer.length == 0) return empty;
        return answer;
    }

    public static void main(String[] args) {

        배열만들기2 array = new 배열만들기2();

        System.out.println("Result : " + Arrays.toString(array.solution(5, 555)));
        System.out.println("Result : " + Arrays.toString(array.solution(10, 20)));
    }
}
