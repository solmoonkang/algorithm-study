package baekjoon.단계문제.심화;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 단어공부 {

    private static Map<Character, Integer> alphabetCountMap;
    private static int maxCount;

    private static int maxCharCount;
    private static char maxChar = '?';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine().toUpperCase();

        long maxCountOccurrences = findMostFrequentCharacterWithHashMap(word);
        if (maxCountOccurrences > 1) bufferedWriter.write("?");
        else bufferedWriter.write(String.valueOf(getKeyWithMaxValue()));

        bufferedWriter.newLine();

        bufferedWriter.write(findMostFrequentCharacterWithArray(word) ? "?" : String.valueOf(maxChar));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static long findMostFrequentCharacterWithHashMap(String word) {
        alphabetCountMap = new HashMap<>();

        for (char alphabet : word.toCharArray()) {
            alphabetCountMap.put(alphabet, alphabetCountMap.getOrDefault(alphabet, 0) + 1);
        }

        maxCount = Collections.max(alphabetCountMap.values());
        return alphabetCountMap.values().stream()
                .filter(count -> count.equals(maxCount))
                .count();
    }

    public static Character getKeyWithMaxValue() {
        return alphabetCountMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxCount))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static boolean findMostFrequentCharacterWithArray(String word) {
        int[] frequency = new int[26];

        for (char alphabet : word.toCharArray()) {
            frequency[alphabet - 'A']++;
        }

        int count = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > count) {
                count = frequency[i];
                maxChar = (char) (i + 'A');
                maxCharCount = 1;
            } else if (frequency[i] == count) {
                maxCharCount++;
            }
        }

        return maxCharCount > 1;
    }
}
