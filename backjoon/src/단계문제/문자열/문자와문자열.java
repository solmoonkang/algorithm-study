package 단계문제.문자열;

import java.io.*;

public class 문자와문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();
        int i = Integer.parseInt(bufferedReader.readLine()) - 1;

        bufferedWriter.write(S.charAt(i));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
