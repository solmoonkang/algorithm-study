package 모든문제.level2.복습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class N제곱배열자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        long left = Long.parseLong(stringTokenizer.nextToken());
        long right = Long.parseLong(stringTokenizer.nextToken());
        bufferedReader.close();

        int[] slicedArray = generate2DArraySlice(N, left, right);
        String flatArraySegment = Arrays.stream(slicedArray).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        bufferedWriter.write(flatArraySegment);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int[] generate2DArraySlice(int N, long left, long right) {
        // 문제의 핵심은 2차원 배열을 실제로 만들 필요가 없다. arr[index]의 값은 index의 값만으로 즉시 계산할 수 있다.
        // 1차원 인덱스가 주어졌을 때, 해당 값이 2차원 배열의 어느 칸에 위치하는지 먼저 파악해야 한다.
        // 행 번호, row = index/N,  열 번호, col = index%N

        int size = (int) (right - left + 1);
        int[] slicedArray = new int[size];

        for (long index = left; index <= right; index++) {
            // 1차원 인덱스를 2차원 (행, 열) 좌표로 변환한다.
            long row = index / N;
            long col = index % N;

            // 2차원 배열의 값은 Math.max(행+1, 열+1) 공식으로 즉시 계산 가능하다. 값은 row+1과 col+1 중 큰 값이다.
            int value = (int) (Math.max(row, col) + 1);

            int resultIndex = (int) (index - left);
            slicedArray[resultIndex] = value;
        }

        return slicedArray;
    }

    private static int[] generate2DArraySliceTimeLimitExceeded(int N, long left, long right) {
        // 불필요한 2차원 배열 생성: N이 최대 10^7이라면, N x N 크기의 2차원 배열을 메모리에 생성하는 것은 불가능하며 이를 초기화하는 시간 복잡도는 O(N^2)이다.
        int[][] arrays = new int[N][N];

        for (int index = 1; index <= N; index++) {
            for (int col = 0; col < index; col++) {
                arrays[index - 1][col] = index;
            }

            for (int row = 0; row < index; row++) {
                arrays[row][index - 1] = index;
            }
        }

        // 불필요한 1차원 배열 평탄화: 2차원 배열을 만든 후, 모든 요소를 mergedList에 넣어 1차원 배열로 평탄화하는 과정 역시 O(N^2)이 걸리므로 실패한다.
        List<Integer> mergedList = new ArrayList<>();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                mergedList.add(arrays[row][col]);
            }
        }

        List<Integer> slicedList = new ArrayList<>();
        for (long index = left; index <= right; index++) {
            slicedList.add(mergedList.get((int) index));
        }

        return slicedList.stream().mapToInt(i -> i).toArray();
    }
}
