package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;

public class 음양더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] absolutes = new int[3];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 3; i++) absolutes[i] = Integer.parseInt(stringTokenizer.nextToken());

        boolean[] signs = new boolean[3];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 3; i++) signs[i] = Boolean.parseBoolean(stringTokenizer.nextToken());

        int sum = getNumbersOfSum(absolutes, signs);
        bufferedWriter.write(String.valueOf(sum));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getNumbersOfSum(int[] absolutes, boolean[] signs) {
        int sum = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) sum += absolutes[i];
            else sum -= absolutes[i];
        }

        return sum;
    }
}
