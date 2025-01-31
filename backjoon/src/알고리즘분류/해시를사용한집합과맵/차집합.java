package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.*;

public class 차집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int NA = Integer.parseInt(stringTokenizer.nextToken());
        int NB = Integer.parseInt(stringTokenizer.nextToken());

        Set<Integer> setA = new HashSet<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < NA; i++) setA.add(Integer.parseInt(stringTokenizer.nextToken()));

        Set<Integer> setB = new HashSet<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < NB; i++) setB.add(Integer.parseInt(stringTokenizer.nextToken()));

        List<Integer> exclusiveElementsList = new ArrayList<>();
        for (int number : setA) {
            if (!setB.contains(number)) exclusiveElementsList.add(number);
        }

        Collections.sort(exclusiveElementsList);

        bufferedWriter.write(exclusiveElementsList.size() + "\n");
        for (int number : exclusiveElementsList) bufferedWriter.write(number + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
