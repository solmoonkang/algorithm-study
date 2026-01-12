package 알고리즘분류.문자열;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 알파벳개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String alphabet = bufferedReader.readLine();

        Map<Character, Integer> alphabetMap = new HashMap<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphabetMap.put(ch, 0);
        }

        for (char ch : alphabet.toCharArray()) {
            alphabetMap.put(ch, alphabetMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            stringBuilder.append(alphabetMap.get(ch)).append(" ");
        }

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
