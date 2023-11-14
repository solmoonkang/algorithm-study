package programmers.coding_basic_training.day16;

public class 소문자로바꾸기 {

    public String solution(String myString) {

        return myString.toLowerCase();
    }

    public static void main(String[] args) {

        소문자로바꾸기 lower = new 소문자로바꾸기();

        System.out.println("Result : " + lower.solution("aBcDeFg"));
        System.out.println("Result : " + lower.solution("AAA"));
    }
}
