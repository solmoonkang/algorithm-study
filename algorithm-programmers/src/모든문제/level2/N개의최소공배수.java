package 모든문제.level2;

import java.io.*;
import java.util.StringTokenizer;

public class N개의최소공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        int LCM = getLeastCommonMultiple(numbers);
        bufferedWriter.write(String.valueOf(LCM));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getLeastCommonMultiple(int[] numbers) {
        int answer = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            answer = LCM(answer, numbers[i]);
        }

        return answer;
    }

    /**
     * 최소공배수, LCM(Least Common Multiple) -> LCM(a, b) = a * b / GCD(a, b)
     * - 세 가지 숫자 이상 a1, a2, ..., aN은 LCM(...LCM(a1, a2), ..., aN)으로 표현할 수 있다.
     */
    private static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }

    /**
     * 최대공약수, GCD(Greatest Common Divisor) -> GCD(a, b) = GCD(b, a mod b)
     */
    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
