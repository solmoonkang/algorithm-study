package 알고리즘분류.정렬;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자카드_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, Integer> numberCountMap = new HashMap<>();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            numberCountMap.put(number, numberCountMap.getOrDefault(number, 0) + 1);
        }

        int M = Integer.parseInt(bufferedReader.readLine());

        StringBuilder builder = new StringBuilder();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            int queryNumber = Integer.parseInt(stringTokenizer.nextToken());
            builder.append(numberCountMap.getOrDefault(queryNumber, 0)).append(" ");
        }

        bufferedWriter.write(builder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
