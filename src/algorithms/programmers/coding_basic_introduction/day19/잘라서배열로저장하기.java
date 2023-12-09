package algorithms.programmers.coding_basic_introduction.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 잘라서배열로저장하기 {

    /**
     * [ 문제 설명 ]
     * 문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을 반환하라.
     */
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < my_str.length(); i+= n) {
            list.add(my_str.substring(i, Math.min(my_str.length(), i + n)));
        }
        return list.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        잘라서배열로저장하기 sliceAndSaveArray = new 잘라서배열로저장하기();
        System.out.println("Result: " + Arrays.toString(sliceAndSaveArray.solution("abc1Addfggg4556b", 6)));
        System.out.println("Result: " + Arrays.toString(sliceAndSaveArray.solution("abcdef123", 3)));
    }
}
