package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // Map 인터페이스는 직접적으로 정렬 기능을 제공하지 않기 때문에, Map의 Entry를 List로 변환한 후에 정렬을 수행해야 한다.
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(bestSellerMap.entrySet());
        entryList.sort((currentBookName, nextBookName) -> {
            int bestSellerBook = Integer.compare(nextBookName.getValue(), currentBookName.getValue());
            if (bestSellerBook == 0) return currentBookName.getKey().compareTo(nextBookName.getKey());

            return bestSellerBook;
        });

        bufferedWriter.write(entryList.get(0).getKey());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
