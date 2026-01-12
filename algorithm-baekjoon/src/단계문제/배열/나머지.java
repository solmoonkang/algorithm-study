package 단계문제.배열;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 나머지 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> setNumbers = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            setNumbers.add(number % 42);
        }

        bufferedWriter.write(String.valueOf(setNumbers.size()));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
