package programmers.foundation.level0.day9;

public class 문자열의뒤의n글자 {

    public String solution(String my_string, int n) {

        // 문자열 my_string 과 정수 n이 매개변수로 주어질 때, my_string 의 뒤의 n 글자로 이루어진 문자열을 반환하라

        // 즉, 문자열 my_string 뒤에서 n 번째까지의 문자열을 반환한다
        String answer = my_string.substring(my_string.length() - n);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(answer);

        return stringBuilder.toString();
    }

    public String solution_others(String my_string, int n) {

        return my_string.substring(my_string.length() - n);
    }

    public static void main(String[] args) {

        문자열의뒤의n글자 N = new 문자열의뒤의n글자();

        System.out.println("Result : " + N.solution("ProgrammerS123", 11));
        System.out.println("Result : " + N.solution("He110W0r1d", 5));
    }
}
