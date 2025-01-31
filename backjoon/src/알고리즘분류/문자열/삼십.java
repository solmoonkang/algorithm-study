package 알고리즘분류.문자열;

import java.io.*;
import java.util.Arrays;

public class 삼십 {

    private static final String NOT_FOUND = "-1";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = bufferedReader.readLine();

        // 조건 1. 30의 배수는 반드시 0으로 끝나야 하므로, 주어진 숫자에 0이 포함되어 있어야 한다.
        // 조건 2. 숫자의 각 자리 숫자의 합이 3의 배수여야 한다.
        // 조건 3. 숫자를 내림차순으로 정렬하여 가장 큰 수를 만든다.
        char[] digits = N.toCharArray();

        boolean hasZero = false;
        int total = 0;

        for (char digit : digits) {
            if (digit == '0') hasZero = true;
            total += Character.getNumericValue(digit);
        }

        if (!hasZero || total % 3 != 0) bufferedWriter.write(NOT_FOUND);

        Arrays.sort(digits);
        StringBuilder stringBuilder = new StringBuilder(new String(digits));
        bufferedWriter.write(stringBuilder.reverse().toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
