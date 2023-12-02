package algorithms.programmers.coding_basic_training.day9;

import java.util.ArrayList;
import java.util.List;

public class 접미사인지확인하기 {

    public int solution(String my_string, String is_suffix) {

        List<String> list = new ArrayList<>();

        int answer = 0;

        // 리스트에 어떤 문자열을 넣고, 해당 문자열의 접미사를 리스트에 넣는다

        // 해당 리스트에 is_suffix 문자열과 동일한 문자열이 있다면, 1을 반환하고 없다면, 0을 반환한다

        for (int i = 0; i < my_string.length(); i++) {

            String str = my_string.substring(i);

            list.add(str);
        }

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals(is_suffix)) {

                answer = 1;
            }
        }

        return answer;
    }

    public int solution_others(String my_string, String is_suffix) {

        return my_string.endsWith(is_suffix) ? 1 : 0;
    }

    public static void main(String[] args) {

        접미사인지확인하기 suffix = new 접미사인지확인하기();

        System.out.println("Result : " + suffix.solution("banana", "ana"));
        System.out.println("Result : " + suffix.solution("banana", "nan"));
        System.out.println("Result : " + suffix.solution("banana", "wxyz"));
        System.out.println("Result : " + suffix.solution("banana", "abanana"));
    }
}
