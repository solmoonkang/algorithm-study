package 단계문제.약수배수소수;

import java.io.*;
import java.util.StringTokenizer;

public class 약수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int divisor = 0;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;
                if (count == K) divisor = i;
            }
        }

        bufferedWriter.write(String.valueOf(divisor));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
