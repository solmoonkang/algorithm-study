package programmers.foundation.level0.string;

public class 대문자로바꾸기 {

    public String solution(String myString) {

        return myString.toUpperCase();
    }

    public static void main(String[] args) {

        대문자로바꾸기 upperCase = new 대문자로바꾸기();

        System.out.println("Result : " + upperCase.solution("aBcDeFg"));
    }
}
