package 알고리즘분류.해시를사용한집합과맵.복습문제;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class 베스트셀러 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<String, Integer> bestSellerMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String bookName = bufferedReader.readLine();
            bestSellerMap.put(bookName, bestSellerMap.getOrDefault(bookName, 0) + 1);
        }

        String bestSellerBookName = bestSellerMap.entrySet().stream()
                .sorted((entryA, entryB) -> {
                    int compareValue = entryB.getValue().compareTo(entryA.getValue());
                    if (compareValue == 0) return entryA.getKey().compareTo(entryB.getKey());
                    return compareValue;
                })
                .map(Map.Entry::getKey).findFirst().orElse(null);

        bufferedWriter.write(Objects.requireNonNull(bestSellerBookName));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
