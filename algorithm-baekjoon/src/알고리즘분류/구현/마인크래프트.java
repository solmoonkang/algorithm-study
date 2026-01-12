package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 마인크래프트 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int[][] sequences = new int[N][M];

        int minHeight = 256;
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                sequences[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                minHeight = Math.min(minHeight, sequences[i][j]);
                maxHeight = Math.max(maxHeight, sequences[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int finalHeight = 0;

        for (int target = minHeight; target <= maxHeight; target++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int height = sequences[i][j];

                    // 높이가 target보다 크면, (높이 차이) * 2초 시간 소모, 인벤토리 블록 추가
                    if (height > target) {
                        time += (height - target) * 2;
                        inventory += (height - target);

                    // 높이가 target보다 작으면, (높이 차이) * 1초 시간 소모, 인벤토리 블록 사용
                    } else if (height < target) {
                        time += (target - height) * 1;
                        inventory -= (target - height);
                    }
                }
            }

            if (inventory < 0) continue;

            if (time < minTime || (time == minTime && target > finalHeight)) {
                minTime = time;
                finalHeight = target;
            }
        }

        bufferedWriter.write(minTime + " " + finalHeight);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
