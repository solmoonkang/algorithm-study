package 알고리즘분류.그리디알고리즘.틀린문제;

import java.io.*;
import java.util.StringTokenizer;

public class A에서B {

    private static final int CAN_NOT_MAKE_B = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int operationsNumber = getRequiredChangeAToBOperationsNumber(A, B);
        bufferedWriter.write(String.valueOf(operationsNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getRequiredChangeAToBOperationsNumber(int startNumber, int targetNumber) {
        int minOperationsNumber = 0;

        while (targetNumber > startNumber) {
            if (targetNumber % 2 == 0) targetNumber /= 2;
            else if (targetNumber % 10 == 1) targetNumber /= 10;
            else break;
            minOperationsNumber++;
        }

        return targetNumber != startNumber ? CAN_NOT_MAKE_B : minOperationsNumber + 1;
    }
}
