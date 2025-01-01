package baekjoon.알고리즘분류.해시를사용한집합과맵.복습문제;

import java.io.*;
import java.util.*;

public class 영단어암기는괴로워 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, Integer> englishVocabularyBookMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String englishWord = bufferedReader.readLine();
            englishVocabularyBookMap.put(englishWord, englishVocabularyBookMap.getOrDefault(englishWord, 0) + 1);
        }

        List<String> englishVocabularyBookListByStream = generateVocabularyBookByStream(englishVocabularyBookMap, M);
        for (String englishWord : englishVocabularyBookListByStream) bufferedWriter.write(englishWord + "\n");

        List<Map.Entry<String, Integer>> englishVocabularyBookList = generateVocabularyBook(englishVocabularyBookMap, M);
        for (Map.Entry<String, Integer> englishWord : englishVocabularyBookList)
            bufferedWriter.write(englishWord + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static List<String> generateVocabularyBookByStream(Map<String, Integer> englishVocabularyBookMap, int minLength) {
        return englishVocabularyBookMap.entrySet().stream()
                .filter(englishWord -> englishWord.getKey().length() >= minLength)
                .sorted((englishWord1, englishWord2) -> {
                    int compare = englishWord2.getValue().compareTo(englishWord1.getValue());
                    if (compare == 0) {
                        compare = englishWord2.getKey().length() - englishWord1.getKey().length();
                        if (compare == 0) compare = englishWord1.getKey().compareTo(englishWord2.getKey());
                    }
                    return compare;
                })
                .map(Map.Entry::getKey)
                .toList();
    }

    private static List<Map.Entry<String, Integer>> generateVocabularyBook(Map<String, Integer> englishVocabularyBookMap, int minLength) {
        List<Map.Entry<String, Integer>> filteredList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : englishVocabularyBookMap.entrySet()) {
            if (entry.getKey().length() >= minLength) filteredList.add(entry);
        }

        filteredList.sort((entry1, entry2) -> {
            int compare = entry2.getValue().compareTo(entry1.getValue());
            if (compare == 0) {
                compare = entry2.getKey().length() - entry1.getKey().length();
                if (compare == 0) compare = entry1.getKey().compareTo(entry2.getKey());
            }
            return compare;
        });

        return filteredList;
    }
}
