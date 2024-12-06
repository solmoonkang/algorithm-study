package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;

public class 설탕배달 {

    private static final int[] sugarBags = {3, 5};

    /**
     * 문제 풀이 전략
     * <p>
     * 1. 봉지 크기 설정: 사용 가능한 봉지의 크기는 3키로와 5키로이다.
     * 2. 그리디 선택: 5키로 봉지를 최대한 사용하여 N을 줄여나간다. 5의 배수로 맞추려고 시도한다.
     * - 그 후 남은 양이 3키로 봉지로 나누어 떨어지는지 확인한다.
     * 3. 반복 및 조건 확인: 5키로 봉지를 사용한 후 남은 설탕이 3키로로 나누어 떨어지지 않으면 5키로 봉지 개수를 하나 줄인다.
     * - 해당 과정을 반복하여 N이 0이 될 때까지 진행한다.
     * 4. 결과 출력: N키로를 만들 수 없다면 -1을 반환한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int minSugarBags = 0;

        while (N >= 0) {
            // 최대한 5KG 봉지로 나누어 떨어지도록 N을 줄여나간다.
            if (N % sugarBags[1] == 0) {
                minSugarBags += N / sugarBags[1];
                bufferedWriter.write(String.valueOf(minSugarBags));
                bufferedWriter.flush();
                return;
            }

            // 3KG 봉지 하나를 사용한다.
            N -= sugarBags[0];
            // 봉지 개수를 증가시킨다.
            minSugarBags++;
        }

        bufferedWriter.write("-1");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
