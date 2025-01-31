package 모든문제.level1.복습문제;

public class 약수의합 {

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        약수의합 problem = new 약수의합();

        System.out.println("problem = " + problem.solution(12));
        System.out.println("problem = " + problem.solution(5));
    }
}
