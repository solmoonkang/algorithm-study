package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 카드놓기 {

    private static int N, K;
    private static boolean[] visited;
    private static int[] cardNumbers;
    private static Set<Integer> uniqueNumbers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());
        K = Integer.parseInt(bufferedReader.readLine());

        cardNumbers = new int[N];
        for (int i = 0; i < N; i++) cardNumbers[i] = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N];
        generateNumberCombination(0, "");

        bufferedWriter.write(String.valueOf(uniqueNumbers.size()));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateNumberCombination(int index, String current) {
        if (index == K) {
            // 정수가 완성되면 uniqueNumber Set에 추가한다.
            uniqueNumbers.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < cardNumbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;      // 카드 선택
                generateNumberCombination(index + 1, current + cardNumbers[i]);     // 다음 카드 선택
                visited[i] = false;     // 카드 해제
            }
        }
    }
}
