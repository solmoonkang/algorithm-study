package 알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 단어수학 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        String[] wordMathProblems = new String[N];
        for (int i = 0; i < N; i++) wordMathProblems[i] = bufferedReader.readLine();

        int maxWordSum = getMaxWordSum(wordMathProblems);
        bufferedWriter.write(String.valueOf(maxWordSum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxWordSum(String[] wordMathProblems) {
        // 각 알파벳의 가치를 저장할 배열
        int[] positionValue = new int[26];

        // 각 알파벳의 자릿수 가치를 계산
        for (String word : wordMathProblems) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char alphabet = word.charAt(i);
                // 자릿수에 따라 가치 증가
                positionValue[alphabet - 'A'] += (int) Math.pow(10, length - i - 1);
            }
        }

        // 알파벳과 그 가치를 쌍으로 저장
        List<AlphabetValue> alphabetValueList = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            if (positionValue[c - 'A'] > 0) alphabetValueList.add(new AlphabetValue(c, positionValue[c - 'A']));
        }

        // 가치를 기준으로 내림차순 정렬
        alphabetValueList.sort((a, b) -> b.value - a.value);

        int[] digitMap = new int[26];
        int digit = 9;
        // 높은 가치부터 낮은 숫자를 할당
        for (AlphabetValue alphabetValue : alphabetValueList) digitMap[alphabetValue.alphabet - 'A'] = digit--;

        int totalWordSum = 0;
        for (String word : wordMathProblems) {
            int wordValue = 0;
            // 숫자로 변환
            for (char alphabet : word.toCharArray()) wordValue = wordValue * 10 + digitMap[alphabet - 'A'];
            totalWordSum += wordValue;
        }

        return totalWordSum;
    }

    private record AlphabetValue(char alphabet, int value) {
    }
}
