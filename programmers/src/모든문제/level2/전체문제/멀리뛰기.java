package 모든문제.level2.전체문제;

public class 멀리뛰기 {

    /**
     * [ 문제 설명 ]
     * 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
     * (1칸, 1칸, 1칸, 1칸)
     * (1칸, 2칸, 1칸)
     * (1칸, 1칸, 2칸)
     * (2칸, 1칸, 1칸)
     * (2칸, 2칸)
     * 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다.
     * 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내,
     * 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요.
     * 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
     */

    /**
     * [ 제한 사항 ]
     * n은 1 이상, 2000 이하인 정수입니다.
     */
    private static final int MOD = 1234567;

    public long solution(int n) {
        // TODO: 다시 한 번 풀어보자.
        long[] answer = new long[n + 1];

        answer[1] = 1;
        if (n > 1) answer[2] = 2;

        for (int i = 3; i <= n; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % MOD;
        }

        return answer[n];
    }

    public static void main(String[] args) {
        멀리뛰기 longJump = new 멀리뛰기();

        System.out.println("longJump = " + longJump.solution(4));

        System.out.println("longJump = " + longJump.solution(3));
    }
}
