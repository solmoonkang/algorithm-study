package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 웰컴키트 {

    private static final int APPLICANTS_BY_SIZE = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] sizes = new int[APPLICANTS_BY_SIZE];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < APPLICANTS_BY_SIZE; i++) {
            sizes[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());

        int tshirtOrderCount = getMinTshirtOrderCount(sizes, T);
        bufferedWriter.write(tshirtOrderCount + "\n");

        int[] penOrderCounts = getMaxPenOrderCount(N, P);
        for (int orderCount : penOrderCounts) bufferedWriter.write(orderCount + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinTshirtOrderCount(int[] sizes, int T) {
        int orderCount = 0;

        for (int size : sizes) {
            orderCount += (size + T - 1) / T;
        }

        return orderCount;
    }

    private static int[] getMaxPenOrderCount(int N, int P) {
        int bundles = N / P;
        int single = N % P;

        return new int[]{bundles, single};
    }
}
