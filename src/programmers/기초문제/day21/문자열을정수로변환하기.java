package programmers.기초문제.day21;

public class 문자열을정수로변환하기 {

    public int solution(String n_str) {

        // 숫자로만 이루어진 문자열 n_str이 주어질 때, n_str을 정수로 변환하여 반환하라

        return Integer.parseInt(n_str);
    }

    public static void main(String[] args) {

        문자열을정수로변환하기 convert = new 문자열을정수로변환하기();

        System.out.println("Result : " + convert.solution("10"));
        System.out.println("Result : " + convert.solution("8542"));
    }
}
