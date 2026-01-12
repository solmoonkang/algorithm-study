package 모든문제.level1.복습문제;

public class 기사단원의무기 {

    public int solution(int number, int limit, int power) {
        int[] divisorCounts = new int[number];

        for (int i = 1; i <= number; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) count++;
            }
            divisorCounts[i - 1] = count;
        }

        int answer = 0;
        for (int i = 0; i < divisorCounts.length; i++) {
            if (divisorCounts[i] > limit) divisorCounts[i] = power;
            answer += divisorCounts[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        기사단원의무기 problem = new 기사단원의무기();

        System.out.println("problem = " + problem.solution(5, 3, 2));
        System.out.println("problem = " + problem.solution(10, 3, 2));
    }
}
