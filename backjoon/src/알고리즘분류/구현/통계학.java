package 알고리즘분류.구현;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 통계학 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        double totalNumber = 0;
        for (int i = 0; i < N; i++) {
            totalNumber += numbers[i];
        }

        // TODO: Math.round 메서드를 통해 반올림을 하였지만, 정상적인 값이 출력되지 않는다.
        totalNumber = totalNumber / N;
        double arithmeticMean = Math.round(totalNumber * 10.0) / 10.0;

        Arrays.sort(numbers);

        int median = numbers[(N - 1) / 2];

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int maxFrequency = 0;
        int mode = Integer.MAX_VALUE;
        boolean secondModeFound = false;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = key;
                secondModeFound = false;
            } else if (frequency == maxFrequency) {
                if (!secondModeFound) {
                    secondModeFound = true;
                    mode = key;
                } else if (key < mode) {
                    mode = key;
                }
            }
        }

        int range = numbers[N - 1] - numbers[0];

        bufferedWriter.write(arithmeticMean + "\n" + median + "\n" + mode + "\n" + range + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
