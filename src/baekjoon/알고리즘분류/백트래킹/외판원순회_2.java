package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 외판원순회_2 {

    private static int N;
    private static int[][] W;
    private static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        List<Integer> visitedList = new ArrayList<>();
        visitedList.add(0);
        findMinimumCostForTravel(0, visitedList, 0);
        bufferedWriter.write(String.valueOf(minCost));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void findMinimumCostForTravel(int currentCity, List<Integer> visitedList, int cost) {
        if (visitedList.size() == N) {
            if (W[currentCity][0] != 0) minCost = Math.min(minCost, cost + W[currentCity][0]);
            return;
        }

        for (int nextCity = 0; nextCity < N; nextCity++) {
            if (!visitedList.contains(nextCity) && W[currentCity][nextCity] != 0) {
                visitedList.add(nextCity);
                findMinimumCostForTravel(nextCity, visitedList, cost + W[currentCity][nextCity]);
                visitedList.remove(visitedList.size() - 1);
            }
        }
    }
}
