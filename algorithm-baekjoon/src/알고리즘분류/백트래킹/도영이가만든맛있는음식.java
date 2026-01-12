package 알고리즘분류.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식 {

    private static int N;
    private static int[][] ingredients;
    private static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        ingredients = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            ingredients[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            ingredients[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // 신맛과 쓴맛의 차이를 저장하는 변수를 Integer.MAX_VALUE로 초기화하여 이후 최소값을 비교할 수 있도록 한다.
        minTasteDifference(0, 1, 0);
        bufferedWriter.write(String.valueOf(minDifference));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void minTasteDifference(int index, int sourTaste, int bitterTaste) {
        // 기저 조건: index가 N에 도달하면 모든 재료를 고려한 것이다.
        if (index == N) {
            // 이때, 신맛이 1보다 큰 경우에만 차이를 계산한다. 신맛이 1인 경우는 아무 재료도 선택하지 않은 경우이므로 제외한다.
            if (sourTaste > 1) {
                int tasteDifference = Math.abs(sourTaste - bitterTaste);
                // 계산된 차이를 minDifference 값으로 업데이트한다.
                minDifference = Math.min(minDifference, tasteDifference);
            }

            return;
        }

        // 현재 재료를 포함하지 않는 경우로, index + 1로 다음 재료로 넘어가고, 신맛과 쓴맛은 그대로 유지한다.
        minTasteDifference(index + 1, sourTaste, bitterTaste);
        // 현재 재료를 포함하는 경우로, 신맛은 곱하고, 쓴맛은 더한다. 이때 신맛은 재료의 신맛으로 곱해지며, 쓴맛은 재료의 쓴맛으로 더해진다.
        minTasteDifference(index + 1, sourTaste * ingredients[index][0], bitterTaste + ingredients[index][1]);
    }
}
