package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;

public class 잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String expression = bufferedReader.readLine();
        String[] minusParts = expression.split("-");

        int minValue = 0;

        for (String part : minusParts[0].split("\\+")) {
            minValue += Integer.parseInt(part);
        }

        for (int i = 1; i < minusParts.length; i++) {
            int minusTotal = 0;

            for (String part : minusParts[i].split("\\+")) {
                minusTotal += Integer.parseInt(part);
            }

            minValue -= minusTotal;
        }

        bufferedWriter.write(String.valueOf(minValue));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
