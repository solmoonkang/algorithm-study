package 알고리즘분류.해시를사용한집합과맵;

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

        // 길이가 M 이상인 단어 리스트 선언
        List<Word> filteredWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : englishVocabularyBookMap.entrySet()) {
            if (entry.getKey().length() >= M) filteredWords.add(new Word(entry.getKey(), entry.getValue()));
        }

        // 빈도수 내림찬순, 길이 내림차순, 사전 순 정렬 -> 각 조건에 따라 우선 순위를 정하고 이를 조합하여 정렬해야 한다.
        filteredWords.sort((wordA, wordB) -> {
            if (wordA.count != wordB.count)
                return Integer.compare(wordB.count, wordA.count);
            else if (wordA.word.length() != wordB.word.length())
                return Integer.compare(wordB.word.length(), wordA.word.length());
            else
                return wordA.word.compareTo(wordB.word);
        });

        for (Word word : filteredWords) {
            bufferedWriter.write(word.word + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 단어와 빈도수를 저장하는 Word 클래스
    private static class Word {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
