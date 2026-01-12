package 모든문제.level2;

import java.io.*;
import java.util.StringTokenizer;

public class N제곱배열자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        long left = Long.parseLong(stringTokenizer.nextToken());
        long right = Long.parseLong(stringTokenizer.nextToken());

        int[] numbers = generateNPatternSegment(N, left, right);
        for (int number : numbers) bufferedWriter.write(number + ", ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] generateNPatternSegment(int N, long left, long right) {
        // 1차원 배열의 left부터 right까지의 구간을 찾기 위한 사이즈를 계산한다.
        int size = (int) (right - left + 1);
        int[] sequences = new int[size];

        for (int i = 0; i < size; i++) {
            // 배열의 left~right 범위를 순회해야 하는데, i는 0부터 시작하므로 left + i로 인덱스를 구해야 한다.
            long index = left + i;

            // N x N 배열을 한 줄로 펼쳤을 때, index/N는 몇 번째 행인지, index%N은 몇 번째 열인지를 확인할 수 있다.
            int row = (int) (index / N);
            int column = (int) (index % N);

            // 인덱스가 0부터 시작하기 때문에 +1을 붙이고 max(i, j) 중 어느 쪽이 더 깊은지를 나타낸다.
            sequences[i] = Math.max(row, column) + 1;
        }

        return sequences;
    }
}
