package 모든문제.level2.복습문제;

public class 숫자의표현 {

    // TODO: 꼭 다시 한 번 더 풀어보자. 완벽히 이해가 되지 않았다.
    public int solution(int n) {
        int count = 0;

        for (int i = 1; i * (i + 1) / 2 <= n; i++) {
            if ((n - i * (i + 1) / 2) % i == 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        숫자의표현 problem = new 숫자의표현();

        System.out.println("problem = " + problem.solution(15));
    }
}
