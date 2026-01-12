package 단계문제.문자열;

import java.io.*;

public class 상수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = bufferedReader.readLine().split(" ");
        String reverseA = new StringBuilder(inputs[0]).reverse().toString();
        String reverseB = new StringBuilder(inputs[1]).reverse().toString();

        bufferedWriter.write(reverseA.compareTo(reverseB) > 0 ? reverseA : reverseB);

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
