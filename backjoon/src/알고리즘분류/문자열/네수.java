package 알고리즘분류.문자열;

import java.io.*;

public class 네수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] naturalNumbers = bufferedReader.readLine().split(" ");

        String AB = naturalNumbers[0] + naturalNumbers[1];
        String CD = naturalNumbers[2] + naturalNumbers[3];

        long totalNumber = Long.parseLong(AB) + Long.parseLong(CD);
        bufferedWriter.write(String.valueOf(totalNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
