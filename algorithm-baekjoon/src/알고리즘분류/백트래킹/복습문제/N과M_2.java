package 알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class N과M_2 {

    private static int N, M;
    private static boolean[] visited;
    private static int[] sequence;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        sequence = new int[M];

        generateSortedUniqueSequences(1, 0);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // TODO: 중복을 피하고 오름차순으로 정렬되어 출력하는 부분에서 코드 수정이 필요하다.
    private static void generateSortedUniqueSequences(int start, int depth) {
        if (depth == M) {
            for (int number : sequence) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        // 오름차순 보장: 모든 숫자를 순서대로 탐색하여 같은 숫자를 중복 선택할 수 없다. 수열이 오름차순으로 생성되려면 현재 선택한 숫자보다 큰 숫자만 선택하도록 제한해야 한다.
        for (int i = start; i <= N; i++) {      // 현재 숫자, start부터 시작
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                generateSortedUniqueSequences(i + 1, depth + 1);        // 다음 깊이로 재귀 호출, 다음 숫자는 i + 1
                visited[i] = false;             // 백트래킹: 선택 취소
            }
        }
    }
}
