package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] A = new int[N];
        int[] dynamicArray = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            dynamicArray[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) dynamicArray[i] = Math.max(dynamicArray[i], dynamicArray[j] + 1);
            }
        }

        int maxLength = 0;
        for (int length : dynamicArray) {
            maxLength = Math.max(maxLength, length);
        }

        bufferedWriter.write(String.valueOf(maxLength));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
