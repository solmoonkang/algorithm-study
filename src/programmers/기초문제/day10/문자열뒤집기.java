package programmers.기초문제.day10;

public class 문자열뒤집기 {

    public String solution(String my_string, int s, int e) {

        // 문자열과 정수가 매개변수로 주어질 때,
        // my_string 에서 인덱스 s부터 인덱스 e까지 뒤집은 문자열을 반환하라

        // StringBuilder 두 개를 선언해서 뒤집을 부분과 그대로 둘 부분을 나눈 다음, 뒤집은 부분을 다시 그대로 둔 부분에 그대로 이식

        StringBuilder stringBuilder = new StringBuilder(my_string);

        String answer = my_string.substring(s, e + 1);

        StringBuilder builder = new StringBuilder(answer);

        builder.reverse();

        stringBuilder.replace(s, e + 1, builder.toString());

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        문자열뒤집기 turn = new 문자열뒤집기();

        System.out.println("Result : " + turn.solution("Progra21Sremm3", 6, 12));
        System.out.println("Result : " + turn.solution("Stanley1yelnatS", 4, 10));
    }
}
