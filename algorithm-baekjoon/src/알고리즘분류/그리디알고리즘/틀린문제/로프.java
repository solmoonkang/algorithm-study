package 알고리즘분류.그리디알고리즘.틀린문제;

import java.io.*;
import java.util.Arrays;

public class 로프 {

    /**
     * 1. 로프를 지지력(버틸 수 있는 무게) 기준으로 내림차순 정렬
     *  - 가장 센 로프부터 약한 로프 순서로 나열한다.
     * 2. K개 로프를 사용했을 때의 최대 올릴 수 있는 무게 계산
     *  - 상위 K개 로프의 최소 지지력이 전체 평균 분산 무게가 된다.
     *  - 즉, K개의 로프 중에 가장 약한 로프(정렬 후 K번째 로프)가 견디는 무게 * K가 그 경우의 최대 중량이다.
     * 3. K를 1부터 N까지 바꿔가며 최대값을 취득
     */

    /**
     * K는 입력으로 주어지는 값이 아니라, N개의 로프 중 몇 개를 고를지를 의미하는 변수이다.
     * 즉, 로프를 1개만 써도 되고, 2개, 3개, ..., N개까지 임의로 골라서 최적의 무게를 만들어야 한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(ropes);

        // k개의 로프를 사용했을 때 들 수 있는 최대 중량을 계산하여 최댓값 갱신
        // ropes[N-k]는 k번째로 센(=선택한 k개 중 최소 지지력) 로프
        int answer = 0;
        for (int k = 1; k <= N; k++) {
            // k개의 로프를 병렬로 걸었을 때 최대 W = k * min
            int capacity = ropes[N - k] * k;
            answer = Math.max(answer, capacity);
        }

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
