package baekjoon.단계문제.문자열;

import java.io.*;
import java.util.StringTokenizer;

public class 문자열반복 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int R = Integer.parseInt(stringTokenizer.nextToken());
            String S = stringTokenizer.nextToken();

            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < S.length(); j++) {
                builder.append(String.valueOf(S.charAt(j)).repeat(Math.max(0, R)));
            }
            bufferedWriter.write(builder.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
