package 모든문제.level1.복습문제;

public class 짝수와홀수 {

    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    public static void main(String[] args) {
        짝수와홀수 problem = new 짝수와홀수();

        System.out.println("problem = " + problem.solution(3));
        System.out.println("problem = " + problem.solution(4));
    }
}
