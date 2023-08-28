package programmers.kit.sort;

import java.util.Arrays;

public class 가장큰수 {

    public String solution(int[] numbers) {

        // 입력된 숫자 배열의 길이와 같은 길이의 문자열 배열을 생성
        String[] str = new String[numbers.length];

        // 각 숫자를 문자열로 변환하여 str 배열에 저장
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        // 만약, 모든 원소가 '0'일 경우에 대비해 첫 번째 원소가 0인지 확인하고, 그럴 경우 0만 반환
        if (str[0].equals('0')) {
            return "0";
        }

        // StringBuilder 객체를 사용하여 정렬된 결과를 하나로 연결하고
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            // 해당 값을 문자열 형태로 반환
            answer.append(str[i]);
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        가장큰수 mostBiggerThanOther = new 가장큰수();

        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        System.out.println("Result : " + mostBiggerThanOther.solution(numbers1));
        System.out.println("Result : " + mostBiggerThanOther.solution(numbers2));
    }
}
