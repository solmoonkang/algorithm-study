package 모든문제.level2.복습문제;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 연속부분수열합의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] elements = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) elements[i] = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();

        int subarraySumCount = countUniqueCircularSubarraySums(elements);
        bufferedWriter.write(String.valueOf(subarraySumCount));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int countUniqueCircularSubarraySums(int[] elements) {
        // 원형 수열의 모든 연속 부분 합을 구하는 가장 명확하고 안전한 방법은 배열을 두 배로 확장하는 방법이다.
        int N = elements.length;
        Set<Integer> subarraySumSet = new HashSet<>();

        // elements 배열을 두 개 이어붙인다고 생각하고 실제 배열 선언이 아닌, 인덱스 계산으로 처리한다.
        // (index % N)을 사용하여 가상으로 확장된 배열에 접근한다.

        for (int start = 0; start < N; start++) {
            int currentSum = 0;

            // start 지점으로부터 length 길이만큼 떨어진 원소의 인덱스를 나머지 연산으로 구한다.
            for (int length = 1; length <= N; length++) {
                int elementIndex = (start + length - 1) % N;
                currentSum += elements[elementIndex];
                subarraySumSet.add(currentSum);
            }
        }


        return subarraySumSet.size();
    }
}
