package programmers.알고리즘고득점KIT.DFS_BFS;

public class 네트워크 {

    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, n, computers);
                count++;
            }
        }

        return count;
    }

    private void DFS(int x, int n, int[][] computers) {
        visited[x] = true;

        for (int y = 0; y < n; y++) {
            if (computers[x][y] == 1 && !visited[y]) DFS(y, n, computers);
        }
    }

    public static void main(String[] args) {
        네트워크 network = new 네트워크();

        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println("network = " + network.solution(3, computers1));

        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println("network = " + network.solution(3, computers2));
    }
}
