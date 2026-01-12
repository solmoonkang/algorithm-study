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
        int N = elements.length;
        Set<Integer> subarraySumSet = new HashSet<>();

        for (int start = 0; start < N; start++) {
            int currentSum = 0;

            for (int length = 1; length <= N; length++) {
                int elementIndex = (start + length - 1) % N;
                currentSum += elements[elementIndex];
                subarraySumSet.add(currentSum);
            }
        }


        return subarraySumSet.size();
    }













    private static int countUniqueCircularSubarraySumsDemo(int[] elements) {
        Set<Integer> subarraySumSet = new HashSet<>();
        int N = elements.length;
        int subarraySum = 0;

        for (int i = 0; i < N; i++) {

            // 내부 반복문 범위: 부분 수열의 길이를 의미하며, 부분 수열의 길이는 최소 1이어야 하며, 원형 수열의 최대 길이는 N까지 가능하다.
            // 따라서 시작점 i가 고정되었을 때, 만들 수 있는 부분 수열의 길이는 1, 2, 3, ..., N이 된다.
            for (int j = 1; j <= N; j++) {
                // 인덱스 계산: 현재 j 길이의 부분 수열에 새로 추가될 원소의 인덱스를 찾는 역할을 한다.

                // 인덱스 오프셋 보정(-1): 부분 수열의 길이는 1부터 세지만, 배열의 인덱스 오프셋은 0부터 카운트한다.
                    // 따라서 길이 j의 부분 수열에 포함된 마지막 원소의 인덱스를 찾으려면 j-1을 빼서 오프셋을 맞춰야 한다.
                // 원형 순환(%N): 오프셋이 결정된 후, 시작점 i와 오프셋을 더하면 새로운 원소의 인덱스가 나온다.
                    // 임시 인덱스 = start(i) + (length(j) - 1)
                    // 임시 인덱스가 배열의 끝 N-1을 넘어갈 때, 나머지 연산을 사용하면 자동으로 인덱스 0부터 순환하게 된다.
                int index = (i + j - 1) % N;
                subarraySum += elements[index];
                subarraySumSet.add(subarraySum);
            }
        }

        return subarraySumSet.size();
    }
}
