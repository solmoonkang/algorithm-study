package 모든문제.level1;

import java.io.*;

public class 나머지가1이되는수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int number = getMinDivisorWithRemainderOne(N);
        bufferedWriter.write(String.valueOf(number));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinDivisorWithRemainderOne(int N) {
        int number = 0;

        for (int X = 1; X <= N; X++) {
            if (N % X == 1) {
                number = X;
                break;
            }
        }

        return number;
    }
}
