package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, String> savedSiteMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            savedSiteMap.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String siteName = bufferedReader.readLine();
            if (savedSiteMap.containsKey(siteName)) stringBuilder.append(savedSiteMap.get(siteName)).append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
