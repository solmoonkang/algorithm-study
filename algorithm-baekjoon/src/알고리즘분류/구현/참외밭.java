package 알고리즘분류.구현;

import java.io.*;
import java.util.*;

public class 참외밭 {

    private static final int HEXAGON_LENGTH = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(bufferedReader.readLine());

        int[] directions = new int[HEXAGON_LENGTH];
        int[] lengths = new int[HEXAGON_LENGTH];

        for (int i = 0; i < HEXAGON_LENGTH; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            directions[i] = Integer.parseInt(stringTokenizer.nextToken());
            lengths[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxWidth = 0, widthIndex = 0;
        int maxHeight = 0, heightIndex = 0;

        for (int i = 0; i < HEXAGON_LENGTH; i++) {
            if ((directions[i] == 1 || directions[i] == 2) && lengths[i] > maxWidth) {
                maxWidth = lengths[i];
                widthIndex = i;
            }

            if ((directions[i] == 3 || directions[i] == 4) && lengths[i] > maxHeight) {
                maxHeight = lengths[i];
                heightIndex = i;
            }
        }

        int smallWidth = lengths[(heightIndex + 3) % HEXAGON_LENGTH];
        int smallHeight = lengths[(widthIndex + 3) % HEXAGON_LENGTH];

        int area = (maxWidth * maxHeight - smallWidth * smallHeight) * K;
        bufferedWriter.write(String.valueOf(area));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
