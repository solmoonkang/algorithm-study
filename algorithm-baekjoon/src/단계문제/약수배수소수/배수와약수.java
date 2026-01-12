package 단계문제.약수배수소수;

import java.io.*;

public class 배수와약수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = bufferedReader.readLine().split(" ");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            if (A == 0 && B == 0) break;

            bufferedWriter.write((B % A == 0) ? "factor\n" : (A % B == 0) ? "multiple\n" : "neither\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
