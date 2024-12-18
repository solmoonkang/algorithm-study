package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 암호만들기 {

    private static int L, C;
    private static char[] alphabets;

    private static final List<String> validPasswords = new ArrayList<>();
    private static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        L = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        alphabets = new char[C];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < C; i++) alphabets[i] = stringTokenizer.nextToken().charAt(0);

        Arrays.sort(alphabets);
        generatePossiblePasswords(0, "", 0, 0);

        for (String password : validPasswords) bufferedWriter.write(password + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generatePossiblePasswords(int index, String current, int vowelCount, int consonantCount) {
        // 암호의 길이가 L이 되면
        if (current.length() == L) {
            if (vowelCount >= 1 && consonantCount >= 2) validPasswords.add(current);
            return;
        }

        // 주어진 알파벳 중 조합 생성
        for (int i = index; i < C; i++) {
            char alphabet = alphabets[i];
            if (isVowel(alphabet)) generatePossiblePasswords(i + 1, current + alphabet, vowelCount + 1, consonantCount);
            else generatePossiblePasswords(i + 1, current + alphabet, vowelCount, consonantCount + 1);
        }
    }

    // 모음인지 자음인지 확인
    private static boolean isVowel(char alphabet) {
        for (char vowel : vowels) {
            if (alphabet == vowel) return true;
        }

        return false;
    }
}
