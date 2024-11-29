package baekjoon.단계문제.투포인터;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 냅색문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        long C = Long.parseLong(stringTokenizer.nextToken());

        long[] weights = new long[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        int middle = N / 2;

        // 부분 집합 합을 저장할 리스트 선언
        List<Long> leftSumList = new ArrayList<>();
        List<Long> rightSumList = new ArrayList<>();

        // 첫 번쨰 절반의 모든 부분 집합의 합을 저장
        for (int i = 0; i < (1 << middle); i++) {
            long sum = 0;

            for (int j = 0; j < (N - middle); j++) {
                if ((i & (1 << j)) != 0) sum += weights[middle + j];
            }

            leftSumList.add(sum);
        }

        // 두 번째 절반의 모든 부분 집합의 합을 저장
        for (int i = 0; i < (1 << (N - middle)); i++) {
            long sum = 0;

            for (int j = 0; j < (N - middle); j++) {
                if ((i & (1 << j)) != 0) sum += weights[middle + j];
            }

            rightSumList.add(sum);
        }

        // 두 번째 리스트를 정렬
        Collections.sort(rightSumList);

        long count = 0;

        // 첫 번째 리스트의 각 합에 대해 이진 탐색
        for (long leftSum : leftSumList) {
            long target = C - leftSum;

            int index = upperBound(rightSumList, target);
            count += index;
        }

        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // upperBound: target 이하의 값의 개수
    private static int upperBound(List<Long> list, long target) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int middle = (low + high) / 2;

            if (list.get(middle) <= target) low = middle + 1;
            else high = middle;
        }

        return low;
    }
}
