package 알고리즘분류.문자열;

import java.io.*;
import java.util.StringTokenizer;

public class 뒤집힌덧셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String X = stringTokenizer.nextToken();
        String Y = stringTokenizer.nextToken();

        int numberX = Integer.parseInt(reverseNumber(X));
        int numberY = Integer.parseInt(reverseNumber(Y));

        int sum = numberX + numberY;

        String result = reverseNumber(String.valueOf(sum));
        bufferedWriter.write(result);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String reverseNumber(String number) {
        return new StringBuilder(number).reverse().toString().replaceAll("^0+", "");
    }
}
