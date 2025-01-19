package baekjoon.알고리즘분류.문자열;

import java.io.*;
import java.util.Arrays;

public class 팰린드롬만들기 {

    private static final String CANNOT_GIFT_PALINDROME = "I'm Sorry Hansoo";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String englishName = bufferedReader.readLine();
        bufferedWriter.write(makePalindromeName(englishName));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String makePalindromeName(String englishName) {
        int[] charCount = new int[26];
        for (char ch : englishName.toCharArray()) charCount[ch - 'A']++;

        StringBuilder stringBuilder = new StringBuilder();
        String middleName = "";

        for (int i = 0; i < 26; i++) {
            if (charCount[i] % 2 == 1) {
                if (middleName.isEmpty()) middleName = String.valueOf((char) (i + 'A'));
                else return CANNOT_GIFT_PALINDROME;
            }

            stringBuilder.append(String.valueOf((char) (i + 'A')).repeat(Math.max(0, charCount[i] / 2)));
        }

        char[] halfArray = stringBuilder.toString().toCharArray();
        Arrays.sort(halfArray);
        stringBuilder = new StringBuilder(new String(halfArray));

        StringBuilder palindromeName = new StringBuilder(stringBuilder);
        if (!middleName.isEmpty()) palindromeName.append(middleName);
        palindromeName.append(stringBuilder.reverse());

        return palindromeName.toString();
    }
}
