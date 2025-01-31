package 알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class 암호만들기 {

    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int L, C;
    private static char[] alphabets;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        L = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        alphabets = new char[C];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < C; i++) {
            alphabets[i] = stringTokenizer.nextToken().charAt(0);
        }

        Arrays.sort(alphabets);
        findPassword(0, 0, new StringBuilder());
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 암호로 사용했을 법한 문자의 종류 C가지를 백트래킹을 통해 구한다.
    private static void findPassword(int start, int depth, StringBuilder password) {
        if (depth == L) {
            if (isValid(password)) stringBuilder.append(password).append("\n");
            return;
        }

        for (int i = start; i < C; i++) {
            password.append(alphabets[i]);
            findPassword(i + 1, depth + 1, password);
            password.deleteCharAt(password.length() - 1);
        }
    }

    private static boolean isValid(StringBuilder password) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < password.length(); i++) {
            char alphabet = password.charAt(i);

            if (vowels.contains(alphabet)) vowelCount++;
            else consonantCount++;
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }
}
