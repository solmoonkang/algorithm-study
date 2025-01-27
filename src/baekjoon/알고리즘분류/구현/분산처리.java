package baekjoon.알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 분산처리 {

    private static final int BASE_COMPUTERS = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            int lastComputerNumber = getLastDigit(A, B);
            bufferedWriter.write(lastComputerNumber + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // A^B의 값이 매우 클 수 있어, 직접 계산 시 오버플로우가 발생할 수 있어, 1의 자리 숫자만 계산한다.
    // 각 숫자의 거듭제곱의 1의 자리 숫자는 주기적으로 반복된다. 해당 주기를 이용하면 반복 계산을 피할 수 있어 효율적이다.
    // 직접 거듭제곱을 계산하는 대신, 주기를 이용해 B에 대한 결과를 빠르게 도출할 수 있다. 특히, B가 큰 경우에도 빠르게 결과를 얻을 수 있다.
    private static int getLastDigit(int A, int B) {
        // A의 1의 자리 숫자를 저장한다.
        int lastDigitBase = A % 10;
        // 만약, B가 0일 경우 모든 수의 0 제곱은 1이므로, 1을 반환한다.
        if (B == 0) return 1;

        // A^1, A^2, A^3, ...의 1의 자리 숫자 주기를 저장한다.
        int[] cycle = new int[BASE_COMPUTERS];
        int index = 0;
        // 이미 계산된 1의 자리 숫자를 추적한다.
        boolean[] seen = new boolean[BASE_COMPUTERS];

        while (true) {
            int currentLastDigit = (int) (Math.pow(lastDigitBase, index + 1) % 10);
            if (seen[currentLastDigit]) break;

            seen[currentLastDigit] = true;
            cycle[index++] = currentLastDigit;
        }

        int cycleLength = index;
        int cycleIndex = (B - 1) % cycleLength;

        return cycle[cycleIndex];
    }
}
