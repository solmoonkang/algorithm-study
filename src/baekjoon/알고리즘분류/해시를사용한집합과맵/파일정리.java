package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class 파일정리 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<String, Integer> fileExtensionMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String fileName = bufferedReader.readLine();
            String[] splitExtensions = fileName.split("\\.");
            fileExtensionMap.put(splitExtensions[1], fileExtensionMap.getOrDefault(splitExtensions[1], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : fileExtensionMap.entrySet()) {
            bufferedWriter.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
