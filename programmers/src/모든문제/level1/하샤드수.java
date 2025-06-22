package 모든문제.level1;

import java.io.*;

public class 하샤드수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(bufferedReader.readLine());

        boolean isHarshad = isHarshadNumber(number);
        bufferedWriter.write(String.valueOf(isHarshad));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean isHarshadNumber(int number) {
        int original = number;
        int digitSum = 0;

        while (number > 0) {
            digitSum += number % 10;
            number /= 10;
        }

        return original % digitSum == 0;
    }
}
