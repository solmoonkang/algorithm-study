package 단계문제.집합과맵;

import java.io.*;
import java.util.*;

public class 듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Set<String> neverHeardPersonSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            neverHeardPersonSet.add(bufferedReader.readLine());
        }

        List<String> neverHeardOrSeenPersonList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String neverSeenPersonName = bufferedReader.readLine();
            if (neverHeardPersonSet.contains(neverSeenPersonName)) neverHeardOrSeenPersonList.add(neverSeenPersonName);
        }

        Collections.sort(neverHeardOrSeenPersonList);

        bufferedWriter.write(neverHeardOrSeenPersonList.size() + "\n");
        for (String neverHeardOrSeenPersonName : neverHeardOrSeenPersonList) {
            bufferedWriter.write(neverHeardOrSeenPersonName + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
