package programmers.기초문제.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열만들기5 {

    public int[] solution(String[] intStrs, int k, int s, int l) {

        List<Integer> list = new ArrayList<>();

        // 배열 intStrs 의 각 원소마다 s번 인덱스에서 시작하는 길이 l짜리 부분 문자열을 잘라내 정수로 변환한다
        for (int i = 0; i < intStrs.length; i++) {

            String str = intStrs[i].substring(s, s + l);

            int strInt = Integer.valueOf(str);

            if (strInt > k) {
                list.add(strInt);
            }
        }

        // 이때, 변환한 정수값이 k보다 큰 값들을 담는 배열을 반환하라

        int[] answer = list.stream().mapToInt(o -> o).toArray();

        return answer;
    }

    public static void main(String[] args) {

        배열만들기5 makeArray5 = new 배열만들기5();

        String[] intStrs = {"0123456789", "9876543210", "9999999999999"};

        System.out.println("Result : " + Arrays.toString(makeArray5.solution(intStrs, 50000, 5, 5)));
    }
}
