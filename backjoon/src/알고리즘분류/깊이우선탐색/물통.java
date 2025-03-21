package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 물통 {

    private static int A, B, C;
    // 상태 a, b를 중복 탐색하지 않기 위해서이다. a와 b만 저장하는 이유는 C의 값은 항상 C - a - b로 구할 수 있다.
    private static boolean[][] visited;
    // A 물통이 비어 있을 때, C 물통에 들어있을 수 있는 물의 양들을 기록하려고 사용합니다. 값이 true인 c만 모아서 출력한다.
    private static boolean[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        A = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[201][201];
        answer = new boolean[201];

        BFS();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 200; i++) {
            if (answer[i]) stringBuilder.append(i).append(" ");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS() {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{0, 0});
        visited[0][0] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();

            int a = current[0];
            int b = current[1];
            int c = C - a - b;

            if (a == 0) answer[c] = true;

            movement(searchDeque, a, b, c, a, b, B, 'A', 'B');
            movement(searchDeque, a, b, c, a, c, C, 'A', 'C');
            movement(searchDeque, a, b, c, b, a, A, 'B', 'A');
            movement(searchDeque, a, b, c, b, c, C, 'B', 'C');
            movement(searchDeque, a, b, c, c, a, A, 'C', 'A');
            movement(searchDeque, a, b, c, c, b, B, 'C', 'B');
        }
    }

    /**
     * movement()는 물 붓는 행동 하나를 시뮬레이션하는 메서드이다.
     * @param searchDeque: BFS 탐색용 덱
     * @param a: 현재 상태에서 A 통에 들어있는 물의 양
     * @param b: 현재 상태에서 B 통에 들어있는 물의 양
     * @param c: 현재 상태에서 C 통에 들어있는 물의 양
     * @param fromValue: 물을 붓는 통에 현재 들어있는 물의 양
     * @param toValue: 물을 받는 통에 현재 들어있는 물의 양
     * @param toCapacity: 물을 받는 통의 최대 용량
     * @param from: 어디서 붓는지 (A / B / C 중 하나)
     * @param to: 어디로 붓는지 (A / B / C 중 하나)
     */
    private static void movement(Deque<int[]> searchDeque, int a, int b, int c, int fromValue, int toValue, int toCapacity, char from, char to) {
        int move = Math.min(fromValue, toCapacity - toValue);
        int newA = a;
        int newB = b;
        int newC = c;

        switch (from) {
            case 'A': newA -= move; break;
            case 'B': newB -= move; break;
            case 'C': newC -= move; break;
        }

        switch (to) {
            case 'A': newA += move; break;
            case 'B': newB += move; break;
            case 'C': newC += move; break;
        }

        if (!visited[newA][newB]) {
            visited[newA][newB] = true;
            searchDeque.offerLast(new int[]{newA, newB});
        }
    }
}
