package 알고리즘분류.문자열;

import java.io.*;
import java.util.*;

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

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(bestSellerMap.entrySet());

        entryList.sort((entryA, entryB) -> {
            int compare = entryB.getValue().compareTo(entryA.getValue());
            if (compare == 0) return entryA.getKey().compareTo(entryB.getKey());
            return compare;
        });

        bufferedWriter.write(entryList.get(0).getKey());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
