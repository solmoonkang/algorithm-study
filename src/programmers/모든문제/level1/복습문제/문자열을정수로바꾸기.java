package programmers.모든문제.level1.복습문제;

public class 문자열을정수로바꾸기 {

    public int solution(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        문자열을정수로바꾸기 problem = new 문자열을정수로바꾸기();

        System.out.println("problem = " + problem.solution("1234"));
        System.out.println("problem = " + problem.solution("-1234"));
    }
}
