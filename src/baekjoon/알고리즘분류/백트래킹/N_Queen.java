package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class N_Queen {

    private static int N;
    private static boolean[] isQueenPlaced;
    private static List<Integer> queenPositions;
    private static int wayCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        isQueenPlaced = new boolean[N];
        queenPositions = new ArrayList<>();

        placeQueen(0);

        bufferedWriter.write(String.valueOf(wayCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void placeQueen(int depth) {
        if (depth == N) {
            wayCount++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isQueenPlaced[i] && possibility(depth, i)) {
                isQueenPlaced[i] = true;
                queenPositions.add(i);

                placeQueen(depth + 1);

                isQueenPlaced[i] = false;
                queenPositions.remove(queenPositions.size() - 1);
            }
        }
    }

    private static boolean possibility(int depth, int col) {
        for (int i = 0; i < depth; i++) {
            if (queenPositions.get(i) == col || Math.abs(depth - i) == Math.abs(col - queenPositions.get(i)))
                return false;
        }

        return true;
    }
}
