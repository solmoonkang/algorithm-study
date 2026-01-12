package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;

public class 직사각형별찍기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                bufferedWriter.write("*");
            }
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        bufferedReader.close();
    }
}
