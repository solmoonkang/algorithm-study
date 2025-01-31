package 기출문제.KAKAO_WINTER_INTERNSHIP_2024;

import java.io.*;
import java.util.*;

public class 도넛과막대그래프 {

    // TODO: 기대 값과 예상 값이 다르다. 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] edges = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            edges[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            edges[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] createdVertexAndGraphCounts = graphAnalyzer(edges);
        bufferedWriter.write(Arrays.toString(createdVertexAndGraphCounts));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] graphAnalyzer(int[][] edges) {
        Map<Integer, Integer> outDegreeMap = new HashMap<>();
        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        Set<Integer> verticesSet = new HashSet<>();

        for (int[] edge : edges) {
            int A = edge[0], B = edge[1];

            outDegreeMap.put(A, outDegreeMap.getOrDefault(A, 0) + 1);
            inDegreeMap.put(B, inDegreeMap.getOrDefault(B, 0) + 1);

            verticesSet.add(A);
            verticesSet.add(B);
        }

        int donutGraphCount = 0, barGraphCount = 0, eightGraphCount = 0;
        int createdVertex = 0;

        for (int vertex : verticesSet) {
            int outDegree = outDegreeMap.getOrDefault(vertex, 0);
            int inDegree = inDegreeMap.getOrDefault(vertex, 0);

            if (outDegree == 1 && inDegree == 1) donutGraphCount++;
            else if (outDegree == 1 && inDegree == 0) barGraphCount++;
        }

        if (donutGraphCount >= 2) eightGraphCount = donutGraphCount / 2;

        for (int vertex : verticesSet) {
            if (outDegreeMap.getOrDefault(vertex, 0) == 0 && inDegreeMap.getOrDefault(vertex, 0) > 0) {
                createdVertex = vertex;
                break;
            }
        }

        return new int[]{createdVertex, donutGraphCount, barGraphCount, eightGraphCount};
    }
}
