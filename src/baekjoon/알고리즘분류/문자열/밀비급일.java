package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class 밀비급일 {

    private static final String END_OF_MESSAGE = "END";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder reversedBuilder = new StringBuilder();
        StringBuilder cipherBuilder = new StringBuilder();

        while (true) {
            String message = bufferedReader.readLine();
            if (message.equals(END_OF_MESSAGE)) break;

            reversedBuilder.append(message).reverse();
            cipherBuilder.append(reversedBuilder).append("\n");
            reversedBuilder.setLength(0);
        }

        bufferedWriter.write(cipherBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
