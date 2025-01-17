package baekjoon.알고리즘분류.문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 농구경기 {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final int SAME_FIRST_LETTER_PLAYERS = 5;
    private static final String CANNOT_SELECT_FIVE_PLAYERS = "PREDAJA";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        sortedFirstLettersLastNameArray(N, bufferedReader);

        bufferedWriter.write(stringBuilder.isEmpty() ? CANNOT_SELECT_FIVE_PLAYERS : stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void sortedFirstLettersLastNameMap(int N, BufferedReader bufferedReader) throws IOException {
        Map<Character, Integer> playerLastNameMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String lastName = bufferedReader.readLine();
            playerLastNameMap.put(lastName.charAt(0), playerLastNameMap.getOrDefault(lastName.charAt(0), 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(playerLastNameMap.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        for (Map.Entry<Character, Integer> entry : entryList) {
            if (entry.getValue() >= SAME_FIRST_LETTER_PLAYERS) stringBuilder.append(entry.getKey());
        }
    }

    private static void sortedFirstLettersLastNameArray(int N, BufferedReader bufferedReader) throws IOException {
        int[] firstLetterCount = new int[26];

        for (int i = 0; i < N; i++) {
            String lastName = bufferedReader.readLine();
            firstLetterCount[lastName.charAt(0) - 'a']++;
        }

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            if (firstLetterCount[alphabet - 'a'] >= SAME_FIRST_LETTER_PLAYERS) stringBuilder.append(alphabet);
        }
    }
}
