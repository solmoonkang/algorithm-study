package programmers.모든문제.level1.복습문제;

public class 약수의개수와덧셈 {

    public int solution(int left, int right) {
        int count = 0;
        int answer = 0;
        for (int i = left; i <= right; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) count++;
            }

            if (count % 2 == 0) answer += i;
            else answer -= i;
            count = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        약수의개수와덧셈 problem = new 약수의개수와덧셈();

        System.out.println("problem = " + problem.solution(13, 17));
        System.out.println("problem = " + problem.solution(24, 27));
    }
}
