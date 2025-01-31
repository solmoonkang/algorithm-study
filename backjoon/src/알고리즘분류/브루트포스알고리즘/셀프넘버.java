package 알고리즘분류.브루트포스알고리즘;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 셀프넘버 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> generateNumbers = new HashSet<>();

        for (int i = 1; i <= 10000; i++) {
            generateNumbers.add(d(i));
        }

        for (int i = 1; i <= 10000; i++) {
            if (!generateNumbers.contains(i)) bufferedWriter.write(i + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static int d(int N) {
        int sum = N;

        while (N > 0) {
            sum += N % 10;
            N /= 10;
        }

        return sum;
    }
}
