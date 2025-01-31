package 모든문제.level1.복습문제;

public class 두정수사이의합 {

    public long solution(int a, int b) {
        long answer = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            answer += i;
        }

        return answer;
    }

    public static void main(String[] args) {
        두정수사이의합 problem = new 두정수사이의합();

        System.out.println("problem = " + problem.solution(3, 5));
        System.out.println("problem = " + problem.solution(3, 3));
        System.out.println("problem = " + problem.solution(5, 3));
    }
}
