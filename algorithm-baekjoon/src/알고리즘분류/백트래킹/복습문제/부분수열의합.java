package 알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 부분수열의합 {

    private static int N, S;
    private static int[] sequences;
    private static int subsequenceCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());

        sequences = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        // 5. 해당 과정을 재귀적으로 반복
        findSubsequences(0, 0);
        bufferedWriter.write(String.valueOf(subsequenceCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 1. 문제의 해를 나타내는 후보해를 만들기 위해 상태 공간을 탐색: 부분수열을 탐색하는 과정으로 재귀적으로 탐색하여 가능한 모든 조합을 시도한다.
    private static void findSubsequences(int start, int target) {
        // 2. 후보해를 확인하고, 주어진 조건에 부합하는지 판단: 현재 부분수열의 합이 S와 같은지 확인하여 유효할 경우 후보해로 간주된다.
        // 3. 조건에 부합하는 후보해를 찾으면 해를 찾은 것으로 처리하고, 결과를 출력: 조건에 만족하는 경우를 카운트하여 결과를 반환한다.
        if (start > 0 && target == S) {
            subsequenceCount++;
        }


        // 4. 조건에 부합하는 후보해를 찾지 못하면 이전 상태로 돌아가 다음 후보해를 생성: 재귀 호출 후 상태를 복원하여 다른 조합을 탐색할 수 있게 된다.
        for (int i = start; i < N; i++) {
            findSubsequences(i + 1, target + sequences[i]);
        }
    }
}
