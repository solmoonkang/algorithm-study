package 알고리즘분류.문자열.틀린문제;

import java.io.*;

public class Hashing {

    private static final long MODULAR = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(bufferedReader.readLine());
        String lowerAlphabets = bufferedReader.readLine();

        long hashing = 0;
        long RADIX = 31;

        for (int i = 0; i < L; i++) {
            char alphabet = lowerAlphabets.charAt(i);
            int Ai = alphabet - 'a' + 1;

            // RADIX(31)의 (i)제곱을 계산한 값으로, 각 문자의 위치에 따라 가중치를 부여하는 역할을 한다.
            hashing = (hashing + Ai * modularPow(RADIX, i)) % MODULAR;
        }

        bufferedWriter.write(String.valueOf(hashing));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 지수를 이진수로 변환해, 각 비트에 대한 계산으로 효율적으로 R^i를 계산한다.
    private static long modularPow(long radix, long exponent) {
        // 최종적으로 계산된 거듭제곱 값을 저장한다.
        long result = 1;

        // 지수가 0이 될 때까지 반복한다.
        while (exponent > 0) {
            // 지수가 홀수일 경우, 현재의 radix를 result에 곱한다.
            if (exponent % 2 == 1) result = (result * radix) % MODULAR;
            // radix를 제곱하여 업데이트한다.
            radix = (radix * radix) % MODULAR;
            // 지수를 2로 나누어 다음 반복에서 사용한다.
            exponent /= 2;
        }

        return result;
    }
}
