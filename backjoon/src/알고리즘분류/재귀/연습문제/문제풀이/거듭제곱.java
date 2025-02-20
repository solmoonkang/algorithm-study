package 알고리즘분류.재귀.연습문제.문제풀이;

import java.io.*;
import java.util.StringTokenizer;

public class 거듭제곱 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int base = Integer.parseInt(stringTokenizer.nextToken());
        int exponent = Integer.parseInt(stringTokenizer.nextToken());

        double power = generatePower(base, exponent);
        bufferedWriter.write(String.valueOf(power));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static double generatePower(int base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent < 0) return 1.0 / generatePower(base, -exponent);
        return base * generatePower(base, exponent - 1);
    }
}
