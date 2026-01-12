package 알고리즘분류.백트래킹;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_8 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N, M;
    private static int[] sequences;
    private static int[] numbers;

    // 같은 수를 여러 번 골라도 된다는 조건으로 선택한 숫자를 여러 번 사용할 수 있어 visited 배열을 선언하지 않았다.

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(numbers);
        sequences = new int[M];
        generateSequences(0, 0);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateSequences(int start, int depth) {
        if (depth == M) {
            for (int number : sequences) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        // 다음 선택에서 사용할 인덱스를 지정하여, 중복된 선택을 방지하고 비내림차순을 유지하기 위해 사용하지 않고 현재 선택한 숫자를 포함하여 다시 선택할 수 있도록 한다.
        for (int i = start; i < N; i++) {
            sequences[depth] = numbers[i];
            generateSequences(i, depth + 1);
        }
    }
}
