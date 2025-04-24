package 알고리즘분류.구현.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 분산처리 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            int lastComputerNumber = getLastComputerNumber(a, b);
            bufferedWriter.write(lastComputerNumber + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getLastComputerNumber(int a, int b) {
        int lastDigit = modPow(a, b);
        return lastDigit == 0 ? 10 : lastDigit;
    }

    private static int modPow(int a, int b) {
        int result = 1;
        a = a % 10;

        while (b > 0) {
            if (b % 2 == 1) result = (result * a) % 10;
            a = (a * a) % 10;
            b = b / 2;
        }

        return result;
    }
}
