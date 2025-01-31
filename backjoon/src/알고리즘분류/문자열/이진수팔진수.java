package 알고리즘분류.문자열;

import java.io.*;

public class 이진수팔진수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String binaryNumber = bufferedReader.readLine();

        // 2진수의 길이를 3의 배수로 맞추기 위해 필요한 0을 추가한다.
        int padding = (3 - binaryNumber.length() % 3) % 3;

        StringBuilder paddedBinaryNumber = new StringBuilder();
        paddedBinaryNumber.append("0".repeat(padding));
        paddedBinaryNumber.append(binaryNumber);

        StringBuilder octalNumber = new StringBuilder();
        // 3비트씩 묶어서 8진수로 변환한다.
        for (int i = 0; i < paddedBinaryNumber.length() - 1; i += 3) {
            String threeBits = paddedBinaryNumber.substring(i, i + 3);
            // 3비트를 10진수로 변환한다.
            int octalDigit = Integer.parseInt(threeBits, 2);
            // 8진수 문자열에 추가한다.
            octalNumber.append(octalDigit);
        }

        // 메모리 최적화를 위해 불필요한 앞의 0을 제거한다.
        while (octalNumber.length() > 1 && octalNumber.charAt(0) == '0') octalNumber.deleteCharAt(0);

        bufferedWriter.write(octalNumber.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
