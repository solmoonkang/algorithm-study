package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class 대소문자바꾸기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();

        for (char alphabet : word.toCharArray()) {
            if (Character.isLowerCase(alphabet)) stringBuilder.append(Character.toUpperCase(alphabet));
            else stringBuilder.append(Character.toLowerCase(alphabet));
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
