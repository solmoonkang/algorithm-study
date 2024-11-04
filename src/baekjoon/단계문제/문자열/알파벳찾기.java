package baekjoon.단계문제.문자열;

import java.io.*;
import java.util.Arrays;

public class 알파벳찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        int[] position = new int[26];
        Arrays.fill(position, -1);

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int index = ch - 'a';
            if (position[index] == -1) position[index] = i;
        }

        for (int i = 0; i < 26; i++) {
            bufferedWriter.write(position[i] + " ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
