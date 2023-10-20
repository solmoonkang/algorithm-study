package programmers.coding_basic_training.level0.day22;

public class 부분문자열인지확인하기 {

    public int solution(String my_string, String target) {

        // 부분 문자열이란 문자열에서 연속된 일부분에 해당하는 문자열을 의미한다
        // 예를 들어, 문자열 "ana", "ban", anana", "banana", "n" 은 모두 문자열 "banana" 의 부분 문자열이지만,
        // "aaa", "bnana", "wxyz" 는 모두 "banana" 의 부분 문자열이 아니다
        // target 이 문자열 my_string 의 부분 문자열이라면 1을 아니면 0을 반환하라

        if (my_string.contains(target)) {

            return  1;

        } else {

            return  0;

        }
    }

    public static void main(String[] args) {

        부분문자열인지확인하기 confirm = new 부분문자열인지확인하기();

        System.out.println("Result : " + confirm.solution("banana", "ana"));
        System.out.println("Result : " + confirm.solution("banana", "wxyz"));

    }
}
