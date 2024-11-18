package baekjoon.단계문제.심화;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 그룹단어체커 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int groupWordCount = 0;

        for (int i = 0; i < N; i++) {
            String word = bufferedReader.readLine();
            if (isGroupWord(word)) groupWordCount++;
        }

        bufferedWriter.write(String.valueOf(groupWordCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static boolean isGroupWord(String word) {
        Set<Character> usedCharacters = new HashSet<>();
        char lastChar = '\0';

        for (char currentChar : word.toCharArray()) {
            if (currentChar != lastChar) {
                if (usedCharacters.contains(currentChar)) return false;
                usedCharacters.add(currentChar);
            }
            lastChar = currentChar;
        }

        return true;
    }
}
