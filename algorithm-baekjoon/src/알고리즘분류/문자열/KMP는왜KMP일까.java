package 알고리즘분류.문자열;

import java.io.*;

public class KMP는왜KMP일까 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] longFormAlgorithmNames = bufferedReader.readLine().split("-");

        StringBuilder shortFormAlgorithmNames = new StringBuilder();
        for (String longFormAlgorithmName : longFormAlgorithmNames) {
            shortFormAlgorithmNames.append(longFormAlgorithmName.charAt(0));
        }

        bufferedWriter.write(shortFormAlgorithmNames.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
