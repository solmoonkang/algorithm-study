package programmers.coding_basic_training.day18;

import java.util.Arrays;

public class 문자열잘라서정렬하기 {

    public String[] solution(String myString) {

        // "x"를 기준으로 해당 문자열을 잘라내 배열을 만든 후, 사전순으로 정렬한 배열을 반환하라
        // ( 단, 빈 문자열은 반환할 배열에 넣지 않는다 )

        String[] answer = myString.split("x");

        answer = Arrays.stream(answer)
                .filter(a -> !a.isEmpty())
                .toArray(String[]::new);

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {

        문자열잘라서정렬하기 sort = new 문자열잘라서정렬하기();

        System.out.println("Result : " + Arrays.toString(sort.solution("axbxcxdx")));
        System.out.println("Result : " + Arrays.toString(sort.solution("dxccxbbbxaaaa")));
    }
}
