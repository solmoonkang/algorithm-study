package 알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.StringTokenizer;

public class 동전_0 {

    /**
     * 기존 문제 풀이 전략
     * 동전 종류를 내림차순으로 정렬하여 while문을 통해 K가 0보다 클 경우, 현재 동전 종류에 해당하는 가치만큼 K에서 빼면서 동전 개수를 카운트하는 방법을 생각했다.
     * <p>
     * 새로운 문제 풀이 전략
     * 동전은 이미 오름차순으로 정렬되었기 때문에, 가장 큰 동전부터 사용하기 위해 인덱스를 역순으로 접근한다.
     * 적절한 반복문 종료 동작을 추가하여 K가 0이 되면 더 이상 동전을 사용할 필요 없음을 구현한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] coinList = new int[N];

        for (int i = 0; i < N; i++) {
            coinList[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int minCoinNumber = 0;

        for (int i = N - 1; i >= 0; i--) {
            int currentCoin = coinList[i];

            while (K >= currentCoin) {
                K -= currentCoin;
                minCoinNumber++;
            }

            if (K == 0) break;
        }

        bufferedWriter.write(String.valueOf(minCoinNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
