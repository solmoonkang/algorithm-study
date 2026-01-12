package 모든문제.level2.복습문제;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 영어끝말잇기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[M];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) words[i] = stringTokenizer.nextToken();
        bufferedReader.close();

        int[] eliminatedNumbers = getEliminatedFirstPersonNumber(N, words);
        String numbers = Arrays.stream(eliminatedNumbers).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        bufferedWriter.write(numbers);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int[] getEliminatedFirstPersonNumber(int N, String[] words) {
        Set<String> usedWordsSet = new HashSet<>();
        String previousWord = words[0];
        usedWordsSet.add(previousWord);

        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            int wordOrder = i + 1;

            if (previousWord.charAt(previousWord.length() - 1) != currentWord.charAt(0)) {
                return new int[]{(wordOrder - 1) % N + 1, (wordOrder - 1) / N + 1};
            }

            if (usedWordsSet.contains(currentWord)) {
                return new int[]{(wordOrder - 1) % N + 1, (wordOrder - 1) / N + 1};
            }

            usedWordsSet.add(currentWord);
            previousWord = currentWord;
        }

        return new int[]{0, 0};
    }
}
