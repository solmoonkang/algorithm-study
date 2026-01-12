package 모든문제.level2;

import java.io.*;

public class 최댓값과최솟값 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String numbers = bufferedReader.readLine();

        String minAndMaxNumber = getMinAndMaxNumber(numbers);
        bufferedWriter.write(minAndMaxNumber);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String getMinAndMaxNumber(String numberWithBlank) {
        String[] numbers = numberWithBlank.split(" ");

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (String num : numbers) {
            int number = Integer.parseInt(num);
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        return min + " " + max;
    }
}
