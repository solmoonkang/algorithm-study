package baekjoon.알고리즘분류.정렬;

import java.io.*;
import java.util.*;

public class 좌표압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] positions = new int[N];

        Set<Integer> commonNumberSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(stringTokenizer.nextToken());
            commonNumberSet.add(positions[i]);
        }

        List<Integer> uniqueNumberList = new ArrayList<>(commonNumberSet);
        Collections.sort(uniqueNumberList);

        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < uniqueNumberList.size(); i++) {
            rankMap.put(uniqueNumberList.get(i), i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int index : positions) {
            stringBuilder.append(rankMap.get(index)).append(" ");
        }

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
