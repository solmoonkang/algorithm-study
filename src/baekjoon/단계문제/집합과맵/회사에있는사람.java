package baekjoon.단계문제.집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 회사에있는사람 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<String, Boolean> accessLogMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] logEntries = bufferedReader.readLine().split(" ");
            String name = logEntries[0];
            String state = logEntries[1];

            if ("enter".equals(state)) accessLogMap.put(name, true);
            else if ("leave".equals(state)) accessLogMap.put(name, false);
        }

        List<String> currentEmployees = accessLogMap.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .sorted((key1, key2) -> key2.compareTo(key1))
                .collect(Collectors.toList());

        for (String currentEmployee : currentEmployees) {
            bufferedWriter.write(currentEmployee + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
