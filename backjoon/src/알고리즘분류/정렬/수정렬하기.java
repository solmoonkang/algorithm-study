package 알고리즘분류.정렬;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class 수정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Set<Integer> numberSets = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            numberSets.add(Integer.parseInt(bufferedReader.readLine()));
        }

        for (int index : numberSets) {
            bufferedWriter.write(String.valueOf(index));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
