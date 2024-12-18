package baekjoon.알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class N과M_1 {

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

        visited = new boolean[N + 1];       // 1부터 N까지의 숫자를 사용하므로 N+1 크기로 초기화
        sequence = new int[M];

        generateUniqueSequences(0);         // 초기 깊이, depth = 0에서 시작

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 1. 1부터 N까지의 자연수를 저장할 배열이 필요하다. 이 배열은 수열을 구성하는 데 사용된다.
     * 2. 현재 깊이, depth를 매개변수로 수열의 깊이를 관리한다. 이 값이 M에 도달하면 하나의 수열이 완성된 것으로 출력한다.
     * 3. 중복을 피하기 위해 각 숫자가 선택되었는지 여부를 기록하는 방문 배열이 필요하다. 이 배열을 사용하여 이미 선택된 숫자는 다음 호출에서 선택하지 않도록 한다.
     * 4. 각 숫자를 선택할 때마다 재귀적으로 다음 숫자를 선택하는 방식으로 진행한다. 이를 통해 가능한 모든 조합을 생성한다.
     */
    private static void generateUniqueSequences(int depth) {
        if (depth == M) {                                   // 깊이가 M인 수열이 완성된 경우
            for (int number : sequence) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {                              // 아직 방문하지 않은 숫자인 경우
                visited[i] = true;                          // 선택
                sequence[depth] = i;                        // 수열에 추가
                generateUniqueSequences(depth + 1);         // 다음 깊이로 재귀 호출
                visited[i] = false;                         // 백트래킹: 선택 취소
            }
        }
    }
}
