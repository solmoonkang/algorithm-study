package programmers.기초문제.day10;

public class 세로읽기 {

    public String solution(String my_string, int m, int c) {

        // my_string 을 한 줄에 m 글자씩 가로로 적었을 때, 왼쪽부터 세로로 c번째 열에 적힌 글자들을 문자열로 반환하라

        // 문자열을 한 줄에 m 글자씩 가로로 저장한다
        // 해당 글자의 c번째 인덱스의 글자를 저장한다
        // 그렇게 뽑은 문자를 문자열에 저장하여 반환한다

        String answer = "";

        // my_string 에서 c번째 글자를 포함하여서 m번째 글자씩만 저장
        for (int i = c - 1; i < my_string.length(); i += m) {

            char s = my_string.charAt(i);

            answer += s;
        }

        return answer;
    }

    public static void main(String[] args) {

        세로읽기 vertical = new 세로읽기();

        System.out.println("Result : " + vertical.solution("ihrhbakrfpndopljhygc", 4, 2));
        System.out.println("Result : " + vertical.solution("programmers", 1, 1));

        // ihrh -> h
        // bakr -> a
        // fpnd -> p
        // oplj -> p
        // hygc -> y
    }
}
