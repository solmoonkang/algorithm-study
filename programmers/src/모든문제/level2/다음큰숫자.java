package 모든문제.level2;

import java.io.*;

public class 다음큰숫자 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int nextBigNumber = getNextBigNumber(N);
        bufferedWriter.write(String.valueOf(nextBigNumber));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getNextBigNumber(int N) {
        int targetBitCount = Integer.bitCount(N);
        int next = N + 1;

        while (Integer.bitCount(next) != targetBitCount) next++;

        return next;
    }

    private static int getNextHigherNumberWithSameBits(int N) {
        int c = N, c0 = 0, c1 = 0;

        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c0 + c1 == 31 || c0 + c1 == 0) return -1;

        int p = c0 + c1;
        N |= (1 << p);
        N &= -(1 << p);
        N |= (1 << (c1 - 1)) - 1;

        return N;
    }

    private static int getNextPermutation(int N) {
        String binary = Integer.toBinaryString(N);
        int onesCount = binary.replace("0", "").length();

        while (true) {
            N++;
            String nextBinary = Integer.toBinaryString(N);
            if (nextBinary.replace("0", "").length() == onesCount) return N;
        }
    }
}
