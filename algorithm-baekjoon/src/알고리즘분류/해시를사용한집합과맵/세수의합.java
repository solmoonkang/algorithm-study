package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.*;

public class 세수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Set<Integer> U = new HashSet<>();
        for (int i = 0; i < N; i++) U.add(Integer.parseInt(bufferedReader.readLine()));

        List<Integer> sortedUList = new ArrayList<>(U);
        Collections.sort(sortedUList);

        int maxSum = 0;
        for (int i = 0; i < sortedUList.size(); i++) {
            for (int j = 0; j < sortedUList.size(); j++) {
                for (int k = 0; k < sortedUList.size(); k++) {
                    int sum = sortedUList.get(i) + sortedUList.get(j) + sortedUList.get(k);
                    if (U.contains(sum)) maxSum = Math.max(maxSum, sum);
                }
            }
        }

        bufferedWriter.write(String.valueOf(maxSum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
