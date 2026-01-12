package 알고리즘분류.문자열.틀린문제;

import java.io.*;

public class 멋쟁이숫자 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        int maxNumber = getDandyNumbersToLoop(S);
        bufferedWriter.write(String.valueOf(maxNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getDandyNumbersToLoop(String S) {
        int maxNumber = -1;

        for (int i = 0; i < S.length() - 3; i++) {
            String substring = S.substring(i, i + 3);

            if (substring.charAt(0) == substring.charAt(1) && substring.charAt(1) == substring.charAt(2)) {
                int number = Integer.parseInt(substring);
                maxNumber = Math.max(maxNumber, number);
            }
        }

        return maxNumber;
    }
}
