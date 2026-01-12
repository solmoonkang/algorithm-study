package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 빗물 {
    // TODO: 구현 흐름에 대한 이해가 부족하다. 다시 한 번 풀어보자.

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int H = Integer.parseInt(stringTokenizer.nextToken());
        int W = Integer.parseInt(stringTokenizer.nextToken());

        int[] heights = new int[W];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] leftMax = new int[W];
        leftMax[0] = heights[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        int[] rightMax = new int[W];
        rightMax[W - 1] = heights[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        int totalWater = 0;
        for (int i = 0; i < W; i++) {
            int waterAtI = Math.min(leftMax[i], rightMax[i] - heights[i]);
            if (waterAtI > 0) totalWater += waterAtI;
        }

        bufferedWriter.write(String.valueOf(totalWater));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
