package 모든문제.level2.복습문제;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 카펫 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int brown = Integer.parseInt(stringTokenizer.nextToken());
        int yellow = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();

        int[] carpetSize = findLengthAndWidthOfTheCarpet(brown, yellow);
        String lengthAndWidth = Arrays.stream(carpetSize).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        bufferedWriter.write(lengthAndWidth);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int[] findLengthAndWidthOfTheCarpet(int brown, int yellow) {
        int N = brown + yellow;

        for (int i = 1; i <= Math.sqrt(N); i++) {
            // 전체 카펫 크기의 약수가 되는 수들을 확인한다.
            if (N % i == 0) {
                int height = i;
                int width = N / i;

                if ((height - 2) * (width - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[]{0, 0};
    }
}
