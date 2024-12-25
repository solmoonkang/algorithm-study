package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class 아 {

    private static final String REQUIRED_VISIT = "go";
    private static final String NOT_REQUIRED_VISIT = "no";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxSound = bufferedReader.readLine().length() - 1;
        int desiredSound = bufferedReader.readLine().length() - 1;

        bufferedWriter.write(maxSound >= desiredSound ? REQUIRED_VISIT : NOT_REQUIRED_VISIT);
        bufferedWriter.flush();
        bufferedReader.close();
    }
}
