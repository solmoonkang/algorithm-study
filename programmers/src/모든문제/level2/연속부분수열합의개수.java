package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 연속부분수열합의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] elements = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) elements[i] = Integer.parseInt(stringTokenizer.nextToken());

        int subSequenceSum = getCircularSubarraySumCountWithModIndex(elements);
        bufferedWriter.write(String.valueOf(subSequenceSum));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getCircularSubarraySumCountWithCopyArray(int[] elements) {
        int N = elements.length;
        int[] extended = new int[N * 2];
        System.arraycopy(elements, 0, extended, 0, N);
        System.arraycopy(elements, 0, extended, N, N);

        Set<Integer> subSequenceSum = new HashSet<>();

        for (int size = 1; size <= N; size++) {
            for (int start = 0; start < N; start++) {
                int sum = 0;
                for (int i = 0; i < start + size; i++) {
                    sum += extended[i];
                }
                subSequenceSum.add(sum);
            }
        }

        return subSequenceSum.size();
    }

    /**
     * 원형 수열에서 연속 부분 수열의 합을 모두 구하고, 중복을 제거한 개수를 구해야 한다.
     * - 일반적인 수열에서는 연속 부분 수열의 개수가 N(N+1)/2개가 존재한다.
     * - 원형 수열은 마지막 원소 다음에 첫 원소가 이어지는 구조이므로 배열의 끝을 넘더라도 다시 처음부터 연결되는 연속성을 가진다.
     * - 원형 구조에서 슬라이딩 윈도우를 만들기 위해서는 기준 위치에서 연속으로 length개의 원소를 더해야 한다.
     * - start: 부분 수열의 시작 위치, offset: 시작 위치로부터 멀어진 거리(0부터 length-1까지 증가), %N: 인덱스를 배열 길이 N으로 나눈 나머지 -> (start + offset) % N: 배열 끝을 넘으면 다시 0부터 시작하도록 만드는 부분이다.
     */
    private static int getCircularSubarraySumCountWithModIndex(int[] elements) {
        int N = elements.length;
        Set<Integer> subSequenceSum = new HashSet<>();

        for (int size = 1; size <= N; size++) {
            for (int start = 0; start < N; start++) {
                int sum = 0;
                for (int offset = 0; offset < size; offset++) {
                    sum += elements[(start + offset) % N];
                }
                subSequenceSum.add(sum);
            }
        }

        return subSequenceSum.size();
    }
}
