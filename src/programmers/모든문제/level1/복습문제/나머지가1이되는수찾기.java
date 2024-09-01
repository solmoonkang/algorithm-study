package programmers.모든문제.level1.복습문제;

public class 나머지가1이되는수찾기 {

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        나머지가1이되는수찾기 problem = new 나머지가1이되는수찾기();

        System.out.println("problem = " + problem.solution(10));
        System.out.println("problem = " + problem.solution(12));
    }
}
