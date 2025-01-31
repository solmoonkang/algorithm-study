package 단계문제.재귀;

import java.io.*;

public class 팩토리얼_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        long result = factorial(N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long factorial(int number) {
        if (number == 0 || number == 1) return 1;
        else return number * factorial(number - 1);
    }
}
