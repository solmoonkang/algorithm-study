package programmers.입문문제.day6;

public class 문자반복출력하기 {

    /**
     * 문자열 my_string과 정수 n이 매개변수로 주어질 때,
     * my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 반환하라.
     */
    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            for (int j = 0; j < n; j++) {
                answer.append(c);
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        문자반복출력하기 repeat = new 문자반복출력하기();
        System.out.println("Result: " + repeat.solution("hello", 3));
    }
}
