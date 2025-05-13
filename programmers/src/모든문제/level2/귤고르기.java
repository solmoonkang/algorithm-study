package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 귤고르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        int[] tangerine = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) tangerine[i] = Integer.parseInt(stringTokenizer.nextToken());

        int distinctValue = getMinDistinctValue(K, tangerine);
        bufferedWriter.write(String.valueOf(distinctValue));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinDistinctValue(int K, int[] tangerine) {
        Map<Integer, Integer> tangerineCountBySize = new HashMap<>();
        for (int count : tangerine) tangerineCountBySize.put(count, tangerineCountBySize.getOrDefault(count, 0) + 1);

        List<Integer> tangerineCounts = new ArrayList<>(tangerineCountBySize.values());
        tangerineCounts.sort(Comparator.reverseOrder());

        int total = 0, kind = 0;
        for (int tangerineCount : tangerineCounts) {
            total += tangerineCount;
            kind++;
            if (total >= K) break;
        }

        return kind;
    }
}
