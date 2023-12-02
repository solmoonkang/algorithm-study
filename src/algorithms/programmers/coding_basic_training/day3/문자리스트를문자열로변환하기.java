package algorithms.programmers.coding_basic_training.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 문자리스트를문자열로변환하기 {

    public String solution_for(String[] arr) {

        String answer = "";

        // 값이 없는 StringBuilder 객체를 생성한다
        List<String> list = new ArrayList<>(Arrays.asList(arr));

        StringBuilder stringBuilder = new StringBuilder();

        // List 를 순회하여 각 요소를 StringBuilder 객체에 추가한다
        for (String array : list) {
            stringBuilder.append(array);
        }

        // StringBuilder 객체에서 toString( ) 메서드를 호출한다
        answer = stringBuilder.toString();

        return answer;
    }

    public String solution_stream(String[] arr) {

        String answer = "";

        // List 를 Stream 으로 변환한다
        List<String> list = new ArrayList<>(Arrays.asList(arr));

        // Stream 으로 변환된 List 를 Collectors 의 joining( ) 메서드를 사용하여 문자열로 변환한다
        answer = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return answer;
    }

    public String solution_best(String[] arr) {

        return String.join("", arr);
    }

    public static void main(String[] args) {

        String[] arr = {"a", "b", "c"};

        문자리스트를문자열로변환하기 change = new 문자리스트를문자열로변환하기();

        System.out.println("Result : " + change.solution_for(arr));
        System.out.println("Result : " + change.solution_stream(arr));
        System.out.println("Result : " + change.solution_best(arr));
    }
}
