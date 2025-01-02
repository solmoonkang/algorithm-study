package baekjoon.알고리즘분류.해시를사용한집합과맵.복습문제;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class 생태학 {

    private static final int PERCENTAGE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> treeDistributionMap = new TreeMap<>();

        String treeDistribution;
        while ((treeDistribution = bufferedReader.readLine()) != null) {
            treeDistributionMap.put(treeDistribution, treeDistributionMap.getOrDefault(treeDistribution, 0) + 1);
        }

        int totalTreeDistribution = 0;
        for (int count : treeDistributionMap.values()) totalTreeDistribution += count;

        for (Map.Entry<String, Integer> entry : treeDistributionMap.entrySet()) {
            String treeDistributionKey = entry.getKey();
            int treeDistributionValue = entry.getValue();

            double treePercentage = ((double) treeDistributionValue / totalTreeDistribution) * PERCENTAGE;

            bufferedWriter.write(String.format("%s %.4f\n", treeDistributionKey, treePercentage));
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
