package 알고리즘분류.그래프.연습문제;

public class 인접행렬 {

    private static final int N = 5;

    public static void main(String[] args) {
        // index를 1부터 맞추기 위해서 N + 1을 한 값으로 초기화한다.
        int[][] graph = new int[N + 1][N + 1];

        putEdge(graph, 1, 2);
        putEdge(graph, 1, 3);
        putEdge(graph, 1, 4);
        putEdge(graph, 2, 3);
        putEdge(graph, 2, 5);
        putEdge(graph, 3, 4);
        putEdge(graph, 4, 5);

        print(graph);
    }

    private static void putEdge(int[][] graph, int x, int y) {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    private static void print(int[][] graph) {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
