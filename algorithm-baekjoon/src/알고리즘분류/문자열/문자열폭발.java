package 알고리즘분류.문자열;

import java.io.*;

public class 문자열폭발 {

    private static final String EMPTY_STRING = "FRULA";

    // TODO: StringBuilder 혹은 문자열의 메서드에 대한 이해가 부족한 것 같다. 다시 한 번 더 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine();
        String explosionString = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();

        int explosionLength = explosionString.length();

        for (char currentAlphabet : input.toCharArray()) {
            stringBuilder.append(currentAlphabet);

            if (stringBuilder.length() >= explosionLength &&
                    stringBuilder.substring(stringBuilder.length() - explosionLength).equals(explosionString)) {
                stringBuilder.setLength(stringBuilder.length() - explosionLength);
            }
        }

        bufferedWriter.write(stringBuilder.isEmpty() ? EMPTY_STRING : stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
