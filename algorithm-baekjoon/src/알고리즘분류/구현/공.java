package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 공 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(bufferedReader.readLine());

        int[][] positionOfCup = new int[M][2];
        for (int i = 0; i < M; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            positionOfCup[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            positionOfCup[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        boolean[] isBall = new boolean[4];
        isBall[1] = true;

        for (int i = 0; i < M; i++) {
            boolean swapBall = isBall[positionOfCup[i][0]];
            isBall[positionOfCup[i][0]] = isBall[positionOfCup[i][1]];
            isBall[positionOfCup[i][1]] = swapBall;
        }

        for (int i = 1; i <= 3; i++) {
            if (isBall[i]) {
                bufferedWriter.write(String.valueOf(i));
                break;
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
