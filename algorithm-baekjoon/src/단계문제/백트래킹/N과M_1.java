package 단계문제.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class N과M_1 {

    static int N, M;
    static boolean[] visited;   // 선택 여부를 기록하는 배열
    static int[] sequence;      // 현재 수열을 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];   // 1부터 N까지 사용
        sequence = new int[M];          // 길이가 M인 수열

        // 수열 생성 함수 호출
        generateSequence(0, bufferedWriter);

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 수열 생성 함수
    static void generateSequence(int depth, BufferedWriter bufferedWriter) throws IOException {
        if (depth == M) {
            // 길이가 M인 수열이 완성되면 출력
            for (int number : sequence) bufferedWriter.write(number + " ");
            bufferedWriter.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {                                  // 아직 선택하지 않은 숫자
                visited[i] = true;                              // 방문 처리
                sequence[depth] = i;                            // 현재 수를 수열에 추가
                generateSequence(depth + 1, bufferedWriter);    // 다음 깊이로 재귀 호출
                visited[i] = false;                             // 방문 취소 (백트래킹)
            }
        }
    }
}
