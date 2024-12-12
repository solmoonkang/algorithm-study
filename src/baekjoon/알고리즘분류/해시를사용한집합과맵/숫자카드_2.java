package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자카드_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, Integer> numberHashMap = new LinkedHashMap<>();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());

            numberHashMap.put(number, numberHashMap.getOrDefault(number, 0) + 1);
        }

        int M = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());

            if (numberHashMap.containsKey(number)) stringBuilder.append(numberHashMap.get(number)).append(" ");
            else stringBuilder.append("0").append(" ");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
