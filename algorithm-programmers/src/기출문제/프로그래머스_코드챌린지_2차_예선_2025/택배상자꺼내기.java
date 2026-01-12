package 기출문제.프로그래머스_코드챌린지_2차_예선_2025;

import java.io.*;
import java.util.StringTokenizer;

public class 택배상자꺼내기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int w = Integer.parseInt(stringTokenizer.nextToken());
        int num = Integer.parseInt(stringTokenizer.nextToken());

        int count = getTotalBoxCount(n, w, num);
        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getTotalBoxCount(int n, int w, int num) {
        int targetFloor = (num - 1) / w;
        int targetIndex = (num - 1) % w;
        boolean isEventFloor = targetFloor % 2 == 0;

        int realColumn = isEventFloor ? targetIndex : w - 1 - targetIndex;

        int totalFloors = (n + w - 1) / w;
        int count = 1;

        for (int floor = targetFloor + 1; floor < totalFloors; floor++) {
            int startNumber = floor * w + 1;
            int endNumber = Math.min((floor + 1) * w, n);
            int boxesOnFloor = endNumber - startNumber + 1;

            int boxColumn = floor % 2 == 0 ? realColumn : w - 1 - realColumn;

            if (boxColumn < boxesOnFloor) count++;
        }

        return count;
    }
}
