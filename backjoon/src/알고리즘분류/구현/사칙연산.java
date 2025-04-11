package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;
import java.util.function.IntBinaryOperator;

public class 사칙연산 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        IntBinaryOperator[] operations = new IntBinaryOperator[]{
                (a, b) -> a + b,
                (a, b) -> a - b,
                (a, b) -> a * b,
                (a, b) -> a / b,
                (a, b) -> a % b,
        };

        for (IntBinaryOperator operation : operations) {
            int result = operation.applyAsInt(A, B);
            bufferedWriter.write(result + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
