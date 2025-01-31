package 알고리즘분류.그리디알고리즘.복습문제;

import java.io.*;

public class 설탕배달 {

    private static final int THREE_KG_SUGAR_BAG = 3;
    private static final int FIVE_KG_SUGAR_BAG = 5;
    private static final int IMPOSSIBLE_WEIGHT = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int minSugarBag = calculateMinBags(N);
        bufferedWriter.write(String.valueOf(minSugarBag));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateMinBags(int sugarBag) {
        int minSugarBag = 0;

        // 2. 적절성 검사: 설탕의 양이 0 이상인지 검증한다. 0 이하가 되면 더 이상 봉지를 선택할 수 없으므로 -1을 반환한다.
        while (sugarBag >= 0) {
            // 1. 선택 절차: 현재 남은 설탕의 양이 5KG 봉지로 나누어 떨어지는지 확인한다. -> 이를 만족하면, 5KG 봉지를 선택하여 남은 설탕의 양을 기준으로 봉지 개수를 반환한다.
            // 3. 해답 검사: 최종적으로 선택한 봉지 개수를 계산하여 반환한다.
            if (sugarBag % FIVE_KG_SUGAR_BAG == 0) return minSugarBag + sugarBag / FIVE_KG_SUGAR_BAG;
            sugarBag -= THREE_KG_SUGAR_BAG;
            minSugarBag++;
        }

        return IMPOSSIBLE_WEIGHT;
    }
}
