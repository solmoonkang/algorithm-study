package baekjoon.단계문제.집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 문자열집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, Integer> alphabetMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            alphabetMap.put(bufferedReader.readLine(), 0);
        }

        int sameAlphabet = 0;

        for (int i = 0; i < M; i++) {
            if (alphabetMap.containsKey(bufferedReader.readLine())) sameAlphabet++;
        }

        bufferedWriter.write(String.valueOf(sameAlphabet));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
