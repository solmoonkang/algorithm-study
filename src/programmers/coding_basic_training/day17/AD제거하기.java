package programmers.coding_basic_training.day17;

import java.util.Arrays;

public class AD제거하기 {

    public String[] solution(String[] strArr) {

        // 배열 내의 문자열 중 "ad"라는 부분 문자열을 포함하고 있는 모든 문자열을 제거하고,
        // 남은 문자열의 순서를 유지하여 배열로 반환하라

        String[] answer = {};

        answer = Arrays.stream(strArr)
                .filter(item -> !item.contains("ad"))
                .toArray(String[]::new);

        return answer;
    }

    public static void main(String[] args) {

        AD제거하기 ad = new AD제거하기();

        String[] strArr = {"and","notad","abcd"};

        System.out.println("Result : " + Arrays.toString(ad.solution(strArr)));
    }
}
