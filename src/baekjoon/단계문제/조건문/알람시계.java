package baekjoon.단계문제.조건문;

import java.io.*;
import java.util.StringTokenizer;

public class 알람시계 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int H = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        if (M < 45) {
            M = (M + 60) - 45;
            H -= 1;
            if (H < 0) H = 23;
        } else {
            M -= 45;
        }

        bufferedWriter.write(H + " " + M);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
