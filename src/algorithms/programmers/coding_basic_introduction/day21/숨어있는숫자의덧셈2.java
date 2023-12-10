package algorithms.programmers.coding_basic_introduction.day21;

import java.util.ArrayList;
import java.util.List;

public class 숨어있는숫자의덧셈2 {

    /**
     * [ 문제 설명 ]
     * 문자열 my_string이 매개변수로 주어집니다. my_string은 소문자, 대문자, 자연수로만 구성되어있습니다.
     * my_string안의 자연수들의 합을 반환하라.
     */
    public int solution(String my_string) {
        StringBuilder temp = new StringBuilder();
        int sum = 0;

        for (int i = 0; i < my_string.length(); i++) {
            // 현재 문자를 가져온다.
            char c = my_string.charAt(i);

            // 현재 문자가 숫자인지 검사하고,
            if (Character.isDigit(c)) {
                // 만약 숫자라면, temp에 해당 숫자를 추가한다.
                temp.append(c);
            } else {
                // temp에 저장된 숫자가 있는지 확인하고,
                if (!temp.toString().isEmpty()) {
                    // 만약 숫자가 있다면, temp에 저장된 숫자를 정수로 변환하여 sum에 더하고,
                    sum += Integer.parseInt(temp.toString());
                    // temp를 초기화한다.
                    temp = new StringBuilder();
                }
            }
        }
        // 문자열 순회가 끝난 후, temp에 아직 처리되지 않은 숫자가 남아있는지 확인하고,
        if (!temp.toString().isEmpty()) {
            // 남아있다면, 그 숫자를 정수로 변환하여 sum에 더한다.
            sum += Integer.parseInt(temp.toString());
        }

        return sum;
    }

    public static void main(String[] args) {
        숨어있는숫자의덧셈2 sumHiddenNumbers = new 숨어있는숫자의덧셈2();
        System.out.println("Result: " + sumHiddenNumbers.solution("aAb1B2cC34oOp"));
        System.out.println("Result: " + sumHiddenNumbers.solution("1a2b3c4d123Z"));
    }
}
