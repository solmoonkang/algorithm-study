package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class R2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int R1 = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());

        int R2 = (2 * S) - R1;
        bufferedWriter.write(String.valueOf(R2));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
