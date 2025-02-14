package 알고리즘분류.해시를사용한집합과맵.틀린문제;

import java.io.*;
import java.util.*;

public class 영단어암기는괴로워 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int wordNumber = Integer.parseInt(stringTokenizer.nextToken());
        int memorizeWordLength = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, Integer> vocabularyBook = new HashMap<>();

        for (int i = 0; i < wordNumber; i++) {
            String word = bufferedReader.readLine();
            if (word.length() >= memorizeWordLength) vocabularyBook.put(word, vocabularyBook.getOrDefault(word, 0) + 1);
        }

        // Map 인터페이스는 순서를 유지하지 않아 Map의 엔트리(키-값 쌍)를 List로 변환한다.
        // Map.entrySet은 Map의 모든 엔트리를 포함하는 Set을 반환한다.
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(vocabularyBook.entrySet());

        entryList.sort((entryA, entryB) -> {
            // Integer, String 클래스 모두 Comparable 인터페이스를 구현하고 있어 compareTo 메서드를 직접 사용할 수 있다.

            // compareTo는 호출된 객체가 인자로 전달된 객체보다 크면 양수를, 작으면 음수를, 같으면 0을 반환한다.
            // entryB.compareTo(entryA)로 사용하는 이유는 내림차순 정렬을 위해서이다.
            int frequencyCompare = entryB.getValue().compareTo(entryA.getValue());
            if (frequencyCompare != 0) return frequencyCompare;

            int lengthCompare = Integer.compare(entryB.getKey().length(), entryA.getKey().length());
            if (lengthCompare != 0) return lengthCompare;

            // VALUE를 비교할 때: compareTo를 사용하여 Integer형인 VALUE를 직접 비교한다.
            // KEY를 비교할 때: compareTo를 사용하여 String형인 KEY를 직접 비교한다.
            // 길이를 비교할 때: Integer.compare를 사용하여 두 개의 int형인 KEY의 길이를 비교한다.

            return entryA.getKey().compareTo(entryB.getKey());
        });

        for (Map.Entry<String, Integer> entry : entryList) bufferedWriter.write(entry.getKey() + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
