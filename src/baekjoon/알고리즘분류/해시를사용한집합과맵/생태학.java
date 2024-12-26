package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.*;

public class 생태학 {

    private static final int PERCENTAGE_MULTIPLIER = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> treeSpeciesMap = new HashMap<>();

        String treeSpecies;
        while ((treeSpecies = bufferedReader.readLine()) != null) {
            treeSpeciesMap.put(treeSpecies, treeSpeciesMap.getOrDefault(treeSpecies, 0) + 1);
        }

        int totalTreeSpecies = treeSpeciesMap.values().stream().mapToInt(Integer::intValue).sum();

        List<String> sortedSpecies = new ArrayList<>(treeSpeciesMap.keySet());
        Collections.sort(sortedSpecies);

        for (String species : sortedSpecies) {
            double percentage = ((double) treeSpeciesMap.get(species) / totalTreeSpecies) * PERCENTAGE_MULTIPLIER;
            bufferedWriter.write(species + " " + String.format("%.4f", percentage) + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
