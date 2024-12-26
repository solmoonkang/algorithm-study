package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.*;

public class 암기왕 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            Set<Integer> notepadSet = new HashSet<>();

            int N = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) notepadSet.add(Integer.parseInt(stringTokenizer.nextToken()));

            int M = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(stringTokenizer.nextToken());
                if (notepadSet.contains(number)) stringBuilder.append("1").append("\n");
                else stringBuilder.append("0").append("\n");
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
