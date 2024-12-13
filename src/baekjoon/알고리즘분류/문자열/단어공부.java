package baekjoon.알고리즘분류.문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 단어공부 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine().toUpperCase();

        Map<Character, Integer> alphabetMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            alphabetMap.put(word.charAt(i), alphabetMap.getOrDefault(word.charAt(i), 0) + 1);
        }

        int maxCount = 0;
        for (int count : alphabetMap.values()) {
            if (count > maxCount) maxCount = count;
        }

        List<Character> maxKeys = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : alphabetMap.entrySet()) {
            if (entry.getValue() == maxCount) maxKeys.add(entry.getKey());
        }

        bufferedWriter.write(maxKeys.size() == 1 ? String.valueOf(maxKeys.get(0)) : "?");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
