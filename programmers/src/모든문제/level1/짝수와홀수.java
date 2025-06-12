package 모든문제.level1;

import java.io.*;

public class 짝수와홀수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(bufferedReader.readLine());

        String answer = getEvenOrOdd(number);
        bufferedWriter.write(answer);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String getEvenOrOdd(int num) {
        return num % 2 == 0 ? "EVEN" : "ODD";
    }
}
