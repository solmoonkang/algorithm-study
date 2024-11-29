package baekjoon.단계문제.투포인터;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> numberList = new ArrayList<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numberList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int start = 0, end = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        while (end < N) {
            currentSum += numberList.get(end);
            end++;

            while (currentSum >= S) {
                minLength = Math.min(minLength, end - start);
                currentSum -= numberList.get(start);
                start++;
            }
        }

        bufferedWriter.write(minLength != Integer.MAX_VALUE ? String.valueOf(minLength) : "0");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
