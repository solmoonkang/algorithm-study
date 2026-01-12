package 알고리즘분류.그리디알고리즘;

import java.io.*;

public class 세탁소사장동혁 {

    private static final int[] changeList = {25, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int change = Integer.parseInt(bufferedReader.readLine());

            int[] coinCount = new int[4];
            for (int j = 0; j < changeList.length; j++) {
                // 각 코인 종류에 따라 사용할 수 있는 최대 코인의 종류를 저장한다.
                coinCount[j] = change / changeList[j];
                // 저장된 코인의 종류의 가치를 거스름돈에서 제외시킨 금액으로 업데이트한다.
                change %= changeList[j];
            }

            stringBuilder.append(coinCount[0]).append(" ")
                    .append(coinCount[1]).append(" ")
                    .append(coinCount[2]).append(" ")
                    .append(coinCount[3]).append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
