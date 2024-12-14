package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class Hashing {

    private static final long R = 31;
    private static final long M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(bufferedReader.readLine());
        String word = bufferedReader.readLine();

        long hashValue = 0;
        long rPower = 1;        // R^i의 값을 저장할 변수

        for (int i = 0; i < L; i++) {
            char currentAlphabet = word.charAt(i);
            int alphabetNumber = currentAlphabet - 'a' + 1;

            hashValue = (hashValue + (alphabetNumber * rPower) % M) % M;
            rPower = (rPower * R) % M;      // R^i 값 업데이트
        }

        bufferedWriter.write(String.valueOf(hashValue));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
