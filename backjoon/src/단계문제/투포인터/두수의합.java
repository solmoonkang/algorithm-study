package 단계문제.투포인터;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 두수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int X = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, Integer> numberMap = new HashMap<>();

        int correct = 0;

        for (int i = 0; i < N; i++) {
            int complement = X - numbers[i];

            if (numberMap.containsKey(complement)) {
                correct += numberMap.get(complement);
            }
            numberMap.put(numbers[i], numberMap.getOrDefault(numbers[i], 0) + 1);
        }

        bufferedWriter.write(String.valueOf(correct));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
