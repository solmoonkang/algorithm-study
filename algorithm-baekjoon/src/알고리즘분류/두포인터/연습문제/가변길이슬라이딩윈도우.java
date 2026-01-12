package 알고리즘분류.두포인터.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 가변길이슬라이딩윈도우 {

    /**
     * 가변 길이 슬라이딩 윈도우: 가변 길이의 윈도우를 사용하여 배열이나 리스트를 탐색한다.
     * - 윈도우의 크기를 필요에 따라 변경하면서 왼쪽 포인터와 오른쪽 포인터를 이동시키며 필요한 계산을 수행한다.
     * - 이 유형은 최소 길이 부분 배열이나 최대 길이 부분 배열을 찾는 등의 문제에 사용될 수 있다.
     */

    /**
     * 문제 유형: 어떤 조건을 만족하는 최소/최대 길이의 연속 부분 배열 찾기로, 주로 합 >= S인 가장 짧은 부분 배열과 같은 문제에 사용된다.
     * 핵심 아이디어: 윈도우의 길이를 자유롭게 늘렸다 줄였다하며, 조건을 만족할 때까지 right를 확장하고, 만족하면 left를 줄여본다.
     * 예제 문제: 합이 S 이상인 부분 배열 중 가장 짧은 길이를 구하라.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());

        int[] sequences = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        int minLength = getMinLengthSubarray(sequences, S);
        bufferedWriter.write(String.valueOf(minLength));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinLengthSubarray(int[] sequences, int S) {
        // left는 현재 윈도우의 시작 인덱스, right는 현재 윈도우의 끝 인덱스이다.
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;

        for (int right = 0; right < sequences.length; right++) {
            sum += sequences[right];

            while (sum >= S) {
                // right - left + 1은 현재 합이 조건을 만족하는 구간의 정확한 길이이다.
                // right = 3, left = 0이면, [0, 1, 2, 3]이므로 길이 4 = right(3) - left(0) + 1이다.
                minLength = Math.min(minLength, right - left + 1);
                // 왼쪽 포인터를 한 칸 줄이면서 합도 같이 줄이기 위해 사용한다.
                // 그러기 위해선 left를 한 칸 오른쪽으로 보내서 윈도우를 줄여야 하는데, 윈도우에 포함돼 있던 맨 왼쪽 값도 합에서 빼줘야 한다.
                sum -= sequences[left++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
