package 모든문제.level1.복습문제;

public class 문자열다루기기본 {

    public boolean solution(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        return s.length() == 4 || s.length() == 6;
    }

    public static void main(String[] args) {
        문자열다루기기본 problem = new 문자열다루기기본();

        System.out.println("problem = " + problem.solution("a234"));
        System.out.println("problem = " + problem.solution("1234"));
    }
}
