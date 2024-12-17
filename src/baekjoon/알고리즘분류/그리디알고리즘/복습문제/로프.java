package baekjoon.알고리즘분류.그리디알고리즘.복습문제;

import java.io.*;
import java.util.Arrays;

public class 로프 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] W = new int[N];

        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int maxWeight = findMaxWeightWithRopes(W);
        bufferedWriter.write(String.valueOf(maxWeight));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findMaxWeightWithRopes(int[] weights) {
        // 1. 선택 절차: 로프의 최대 중량을 내림차순으로 정렬한다.
        Arrays.sort(weights);

        // 예를 들어, 로프의 최대 중량이 10과 15인 두 개의 로프가 있다고 가정하자.
        // 2개의 로프를 사용하여 중량이 10, 15인 물체를 들어올릴 때, 각각 로프에는 고르게 (10 + 10 / 2), (15 + 15 / 2), (10 + 15 / 2)만큼 중량이 걸리게 된다.
        // 그 외에도 (10 / 2), (15 / 2)만큼의 중량이 걸리도록 해도 된다. 하지만 병렬로 최대 중량을 고르는게 목표이므로 위 3가지 방법 중 한 가지를 선택한다.

        int maxWeight = 0;

        // 2. 적절성 검사: 각 로프를 사용하여 중량이 고르게 분포되도록 가장 적은 중량을 기준으로 최대 중량을 계산해야 한다.
        for (int i = 0; i < weights.length; i++) {
            int currentWeight = weights[i] * (weights.length - i);
            maxWeight = Math.max(currentWeight, maxWeight);
        }

        // 3. 해답 검사: 최대 중량을 반환한다.
        return maxWeight;
    }
}
