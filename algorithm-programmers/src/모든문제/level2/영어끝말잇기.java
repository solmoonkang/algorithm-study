package 모든문제.level2;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 영어끝말잇기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        String[] words = new String[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) words[i] = stringTokenizer.nextToken();

        int[] dropout = getFirstPersonDropout(N, words);
        for (int answer : dropout) bufferedWriter.write(answer + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getFirstPersonDropout(int N, String[] words) {
        Set<String> appearedBeforeWords = new HashSet<>();

        for (int i = 1; i <= words.length; i++) {
            String currentWord = words[i - 1];

            if (appearedBeforeWords.contains(currentWord)) return getEndingWrongPerson(i, N);

            if (i > 1) {
                String previousWord = words[i - 2];
                if (previousWord.charAt(previousWord.length() - 1) != currentWord.charAt(0)) {
                    return getEndingWrongPerson(i, N);
                }
            }

            appearedBeforeWords.add(currentWord);
        }

        return new int[]{0, 0};
    }

    private static int[] getEndingWrongPerson(int index, int N) {
        int number = index % N == 0 ? N : index % N;
        int order = index % N == 0 ? index / N : (index / N) + 1;

        return new int[]{number, order};
    }
}
