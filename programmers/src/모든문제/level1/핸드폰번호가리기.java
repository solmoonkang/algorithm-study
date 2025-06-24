package 모든문제.level1;

import java.io.*;

public class 핸드폰번호가리기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String phoneNumber = bufferedReader.readLine();

        String maskingNumber = getMaskingPhoneNumber(phoneNumber);
        bufferedWriter.write(maskingNumber);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String getMaskingPhoneNumber(String phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        int phoneLength = phoneNumber.length();
        String lastPhoneNumber = phoneNumber.substring(phoneLength - 4, phoneLength);

        stringBuilder.append("*".repeat(Math.max(0, phoneLength - 4)));
        stringBuilder.append(lastPhoneNumber);

        return stringBuilder.toString();
    }

    private static String anotherSolution(String phoneNumber) {
        char[] ch = phoneNumber.toCharArray();
        for (int i = 0; i < ch.length - 4; i++) ch[i] = '*';
        return String.valueOf(ch);
    }
}
