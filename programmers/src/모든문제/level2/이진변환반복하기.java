package 모든문제.level2;

import java.io.*;

public class 이진변환반복하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String binary = bufferedReader.readLine();

        int[] binaryTransform = getBinaryTransform(binary);
        for (int count : binaryTransform) bufferedWriter.write(count + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getBinaryTransform(String binary) {
        int count = 0;
        int zeroCount = 0;

        while (!binary.equals("1")) {
            int originalLength = binary.length();
            binary = binary.replace("0", "");
            int newLength = binary.length();

            zeroCount += (originalLength - newLength);
            binary = Integer.toBinaryString(newLength);
            count++;
        }

        return new int[]{count, zeroCount};
    }

    private static int[] getBinaryTransformWithStream(String binary) {
        int transformCount = 0;
        int removedZeros = 0;

        while (!binary.equals("1")) {
            long zeroCount = binary.chars()
                    .filter(binaryNumber -> binaryNumber == '0')
                    .count();

            removedZeros += (int) zeroCount;

            binary = binary.replace("0", "");
            int length = binary.length();
            binary = Integer.toBinaryString(length);

            transformCount++;
        }

        return new int[]{transformCount, removedZeros};
    }
}
