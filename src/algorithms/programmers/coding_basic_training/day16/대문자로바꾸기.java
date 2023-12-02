package algorithms.programmers.coding_basic_training.day16;

public class 대문자로바꾸기 {

    public String solution(String myString) {

        return myString.toUpperCase();
    }

    public static void main(String[] args) {

        대문자로바꾸기 upper = new 대문자로바꾸기();

        System.out.println("Result : " + upper.solution("aBcDeFg"));
        System.out.println("Result : " + upper.solution("AAA"));
    }
}
