package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class AxB {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        bufferedWriter.write(String.valueOf(A * B));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
