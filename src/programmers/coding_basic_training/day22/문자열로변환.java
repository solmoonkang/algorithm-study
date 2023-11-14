package programmers.coding_basic_training.day22;

public class 문자열로변환 {

    public String solution(int n) {

        return String.valueOf(n);
    }

    public static void main(String[] args) {

        문자열로변환 change = new 문자열로변환();

        System.out.println("Result : "  + change.solution(123));
        System.out.println("Result : "  + change.solution(2573));
    }
}
