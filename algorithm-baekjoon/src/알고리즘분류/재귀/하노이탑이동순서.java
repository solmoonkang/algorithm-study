package 알고리즘분류.재귀;

import java.io.*;

public class 하노이탑이동순서 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int moveCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        // 큰 문제(N개의 원판)를 작은 문제(N-1개의 원판)로 나누어 해결하는 방식이다.
        sequenceMovementsRequiredTaskForHanoi(N, 1, 3, 2);
        bufferedWriter.write(moveCount + "\n" + stringBuilder);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     *
     * @param N: 현재 이동할 원판의 개수
     * @param sourceRod: 원판을 옮길 출발 장대
     * @param destinationRod: 원판을 옮길 목표 장대
     * @param auxiliaryRod: 원판을 임시로 옮길 보조 장대
     */
    private static void sequenceMovementsRequiredTaskForHanoi(int N, int sourceRod, int destinationRod, int auxiliaryRod) {
        // 만약 N이 1이라면, 가장 작은 원판을 sourceRod 장대에서 destinationRod 장대로 직접 이동한다.
        if (N == 1) {
            // 이때 이동 경로를 StringBuilder에 추가하고, 이동 횟수를 증가시킨다.
            stringBuilder.append(sourceRod).append(" ").append(destinationRod).append("\n");
            moveCount++;
            return;
        }

        // 가장 큰 원판을 옮기기 전에, 먼저 위에 있는 N-1개의 원판을 보조 장대(auxiliaryRod)로 이동한다.
        sequenceMovementsRequiredTaskForHanoi(N - 1, sourceRod, auxiliaryRod, destinationRod);
        // 가장 큰 원판을 sourceRod 장대에서 destinationRod로 이동한다. 작업이 끝나면 StringBuilder에 현재 이동 경로를 추가하고, 이동 횟수를 증가시킨다.
        stringBuilder.append(sourceRod).append(" ").append(destinationRod).append("\n");
        moveCount++;

        // 마지막으로, 보조 장대에 있는 N-1개의 원판을 목표 장대 destinationRod로 이동한다.
        sequenceMovementsRequiredTaskForHanoi(N - 1, auxiliaryRod, destinationRod, sourceRod);
    }
}
