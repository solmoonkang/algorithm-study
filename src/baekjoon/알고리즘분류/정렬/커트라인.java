package baekjoon.알고리즘분류.정렬;

import java.io.*;
import java.util.*;

public class 커트라인 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        List<Integer> scoreList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            scoreList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        scoreList.sort(Comparator.reverseOrder());

        bufferedWriter.write(String.valueOf(scoreList.get(K - 1)));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
