package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 내적 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] a = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] b = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) b[i] = Integer.parseInt(stringTokenizer.nextToken());

        int dotProduct = calculateDotProduct(a, b);
        bufferedWriter.write(String.valueOf(dotProduct));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateDotProduct(int[] a, int[] b) {
        int dotProduct = 0;
        for (int i = 0; i < a.length; i++) dotProduct += a[i] * b[i];
        return dotProduct;
    }

    private static int anotherSolution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }
}
