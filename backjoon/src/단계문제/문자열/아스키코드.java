package 단계문제.문자열;

import java.io.*;

public class 아스키코드 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String I = bufferedReader.readLine();

        for (char ch : I.toCharArray()) {
            int ascii = (int) ch;
            bufferedWriter.write(String.valueOf(ascii));
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
