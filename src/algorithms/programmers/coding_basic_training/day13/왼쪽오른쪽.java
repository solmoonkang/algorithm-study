package algorithms.programmers.coding_basic_training.day13;

import java.util.Arrays;

public class 왼쪽오른쪽 {

    public String[] solution(String[] str_list) {

        // str_list에서 l과 r 중
        // 먼저 나오는 문자열이 l이면, 해당 문자열을 기준으로 왼쪽에 있는 문자열들을 순서대로 담은 리스트를,
        // 먼저 나오는 문자열이 r이면, 해당 문자열을 기준으로 오른쪽에 있는 문자열들을 순서대로 담은 리스트를 반환하라
        // ( 단, l이나 r이 없다면, 빈 리스트를 반환하라 )

        String[] answer = {};

        for (int i = 0; i < str_list.length; i++) {

            if (str_list[i].equals("l")) {

                answer = Arrays.copyOfRange(str_list, 0, i);

                break;

            } else if (str_list[i].equals("r")) {

                answer = Arrays.copyOfRange(str_list, i + 1, str_list.length);

                break;

            }
        }

        return answer;
    }

    public static void main(String[] args) {

        왼쪽오른쪽 leftRight = new 왼쪽오른쪽();

        String[] first_str_list = {"u", "u", "l", "r"};
        String[] second_str_list = {"l"};

        System.out.println("Result : " + Arrays.toString(leftRight.solution(first_str_list)));
        System.out.println("Result : " + Arrays.toString(leftRight.solution(second_str_list)));
    }
}
