package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 사파리월드 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        long N = Long.parseLong(stringTokenizer.nextToken());
        long M = Long.parseLong(stringTokenizer.nextToken());

        long differenceInPopularity = Math.abs(N - M);
        bufferedWriter.write(String.valueOf(differenceInPopularity));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
