package 알고리즘분류.브루트포스알고리즘.복습문제;

import java.io.*;

public class 셀프넘버 {

    private static final int MAX_NUMBER_RANGE = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] generated = new boolean[MAX_NUMBER_RANGE + 1];

        for (int i = 1; i <= MAX_NUMBER_RANGE; i++) {
            int constructorNumber = generateConstructorNumberByLoop(i);
            if (constructorNumber <= MAX_NUMBER_RANGE) generated[constructorNumber] = true;
        }

        for (int i = 1; i <= MAX_NUMBER_RANGE; i++) {
            if (!generated[i]) bufferedWriter.write(i + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 반복문을 사용하여 number가 0보다 클 때까지 진행하며, 매 반복마다 number % 10을 통해 마지막 자리수를 추출한다.
    // 이후, constructorNumber에 더하고, number를 10으로 나눠서 다음 자리수를 확인한다.
    private static int generateConstructorNumberByLoop(int number) {
        int constructorNumber = number;

        while (number > 0) {
            constructorNumber += number % 10;
            number /= 10;
        }

        return constructorNumber;
    }

    // 숫자를 문자열로 변환하여 각 자리수를 더하는 방식의 생성자 계산 메서드이다.
    private static int generateConstructorNumberByString(int number) {
        int constructorNumber = number;
        String convertNumber = Integer.toString(number);

        for (int i = 0; i < convertNumber.length(); i++) {
            constructorNumber += convertNumber.charAt(i) - '0';
        }

        return constructorNumber;
    }
}
