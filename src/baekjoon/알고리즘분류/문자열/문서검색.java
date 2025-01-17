package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class 문서검색 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String document = bufferedReader.readLine();
        String findWord = bufferedReader.readLine();

        int wordCount = 0;
        int index = 0;

        while (index <= document.length() - findWord.length()) {
            // 현재 위치에서 findWord가 시작하는지 확인한다.
            if (document.startsWith(findWord, index)) {
                wordCount++;
                // 인덱스를 단어 길이만큼 건너뛴다.
                index += findWord.length();
            } else {
                // 인덱스를 다음 문자로 이동시킨다.
                index++;
            }
        }

        bufferedWriter.write(String.valueOf(wordCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
