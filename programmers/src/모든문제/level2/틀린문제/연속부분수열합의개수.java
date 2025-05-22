package 모든문제.level2.틀린문제;

import java.io.*;
import java.util.*;

public class 연속부분수열합의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] elements = new int[5];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 5; i++) elements[i] = Integer.parseInt(stringTokenizer.nextToken());

        int subSequenceSumCount = getSubSequenceSumCount(elements);
        bufferedWriter.write(String.valueOf(subSequenceSumCount));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getSubSequenceSumCount(int[] elements) {
        Set<Integer> subSequenceSumSet = new HashSet<>();

        for (int length = 1; length <= elements.length; length++) {
            for (int startIndex = 0; startIndex < elements.length; startIndex++) {
                int subSequenceSum = 0;
                for (int i = 0; i < length; i++) {
                    int index = (startIndex + i) % elements.length;
                    subSequenceSum += elements[index];
                }
                subSequenceSumSet.add(subSequenceSum);
            }
        }

        return subSequenceSumSet.size();
    }
}
