package 기초문제.day18;

public class RNY_STRING {

    public String solution(String rny_string) {

        // rny_string 의 모든 'm'을 'rn'으로 바꾼 문자열을 반환하라

        return rny_string.replace("m", "rn");
    }

    public static void main(String[] args) {

        RNY_STRING rnyString = new RNY_STRING();

        System.out.println("Result : " + rnyString.solution("masterpiece"));
        System.out.println("Result : " + rnyString.solution("programmers"));
        System.out.println("Result : " + rnyString.solution("jerry"));
        System.out.println("Result : " + rnyString.solution("burn"));
    }
}
