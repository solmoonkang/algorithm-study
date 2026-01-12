package 단계문제.조합론;

import java.io.*;

public class 베라의패션 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        bufferedWriter.write(String.valueOf(N * (N - 1)));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
