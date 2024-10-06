package programmers.모든문제.level1.복습문제;

public class 소수찾기 {

    // TODO: 에라토스테네스의 체로, i = 2 부터 √N 이하까지 반복하여 자연수들 중 i를 제외한 i의 배수들을 제외시키는 방식이다.
    public int solution(int n) {
        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) continue;

            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }

        int count = 0;
        for (boolean b : prime) {
            if (!b) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        소수찾기 problem = new 소수찾기();

        System.out.println("problem = " + problem.solution(10));
        System.out.println("problem = " + problem.solution(5));
    }
}
