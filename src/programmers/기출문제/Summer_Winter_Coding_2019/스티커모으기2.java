package programmers.기출문제.Summer_Winter_Coding_2019;

public class 스티커모으기2 {

    /**
     * [ 문제 설명 ]
     * N개의 스티커가 원형으로 연결되어 있습니다. 다음 그림은 N = 8인 경우의 예시입니다.
     * 원형으로 연결된 스티커에서 몇 장의 스티커를 뜯어내어 뜯어낸 스티커에 적힌 숫자의 합이 최대가 되도록 하고 싶습니다.
     * 단 스티커 한 장을 뜯어내면 양쪽으로 인접해있는 스티커는 찢어져서 사용할 수 없게 됩니다.
     *
     * 예를 들어 위 그림에서 14가 적힌 스티커를 뜯으면 인접해있는 10, 6이 적힌 스티커는 사용할 수 없습니다.
     * 스티커에 적힌 숫자가 배열 형태로 주어질 때,
     * 스티커를 뜯어내어 얻을 수 있는 숫자의 합의 최댓값을 return 하는 solution 함수를 완성해 주세요.
     * 원형의 스티커 모양을 위해 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어 있다고 간주합니다.
     */

    /**
     * [ 제한 사항 ]
     * sticker는 원형으로 연결된 스티커의 각 칸에 적힌 숫자가 순서대로 들어있는 배열로, 길이(N)는 1 이상 100,000 이하입니다.
     * sticker의 각 원소는 스티커의 각 칸에 적힌 숫자이며, 각 칸에 적힌 숫자는 1 이상 100 이하의 자연수입니다.
     * 원형의 스티커 모양을 위해 sticker 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어있다고 간주합니다.
     */
    public int solution(int[] sticker) {
        // TODO: 배열의 인덱스를 줄 때, 값이 어떻게 할당되는지를 정확히 이해하지 못함. 다시 한 번 풀어보자.
        int N = sticker.length;
        if (N == 1) return sticker[0];

        return Math.max(findMax(sticker, 0, N - 2), findMax(sticker, 1, N - 1));
    }

    // 동적 계획법을 사용하여, 각 위치의 스티커를 뜯을 때와 뜯지 않을 때의 최대 합을 계산한다.
    private int findMax(int[] sticker, int start, int end) {
        int N = end - start + 1;
        int[] dp = new int[N];

        dp[0] = sticker[start];
        dp[1] = Math.max(sticker[start], sticker[start + 1]);

        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[start + i]);
        }

        return dp[N - 1];
    }

    public static void main(String[] args) {
        스티커모으기2 collectSticker = new 스티커모으기2();

        int[] firstSticker = {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println("collectSticker = " + collectSticker.solution(firstSticker));

        int[] secondSticker = {1, 3, 2, 5, 4};
        System.out.println("collectSticker = " + collectSticker.solution(secondSticker));
    }
}
