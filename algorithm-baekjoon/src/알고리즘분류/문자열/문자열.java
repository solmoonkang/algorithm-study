package 알고리즘분류.문자열;

import java.io.*;
import java.util.StringTokenizer;

public class 문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String A = stringTokenizer.nextToken();
        String B = stringTokenizer.nextToken();

        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {
            String substringB = B.substring(i, i + A.length());
            int difference = getDifference(A, substringB);
            minDifference = Math.min(minDifference, difference);
        }

        bufferedWriter.write(String.valueOf(minDifference));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getDifference(String A, String B) {
        int difference = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) difference++;
        }

        return difference;
    }
}
