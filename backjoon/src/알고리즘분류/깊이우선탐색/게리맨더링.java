package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.*;

public class 게리맨더링 {

    // TODO: 이해가 부족한거 같다. 다시 한 번 풀어보자.

    private static final String CANNOT_DIVIDE_TWO_DISTRICTS = "-1";

    private static int N;
    private static int[] population;
    private static List<List<Integer>> arrayLists;
    private static int minPopulationDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        population = new int[N + 1];
        arrayLists = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) arrayLists.add(new ArrayList<>());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) population[i] = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 1; i <= N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int adjacentNumber = Integer.parseInt(input[0]);

            for (int j = 1; j <= adjacentNumber; j++) {
                int neighborNumber = Integer.parseInt(input[j]);
                arrayLists.get(i).add(neighborNumber);
            }
        }

        List<Integer> groupAList = new ArrayList<>();
        divideDistricts(1, groupAList);

        bufferedWriter.write(minPopulationDifference == Integer.MAX_VALUE ?
                CANNOT_DIVIDE_TWO_DISTRICTS : String.valueOf(minPopulationDifference));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void divideDistricts(int index, List<Integer> groupAList) {
        if (index > N) {
            if (!groupAList.isEmpty()) {
                List<Integer> groupBList = new ArrayList<>();

                for (int i = 1; i <= N; i++) {
                    if (!groupAList.contains(i)) groupBList.add(i);
                }

                if (!groupBList.isEmpty() && isConnected(groupAList) && isConnected(groupBList)) {
                    int populationA = getPopulationDifference(groupAList);
                    int populationB = getPopulationDifference(groupBList);

                    int populationDifference = Math.abs(populationA - populationB);
                    minPopulationDifference = Math.min(minPopulationDifference, populationDifference);
                }
            }

            return;
        }

        groupAList.add(index);
        divideDistricts(index + 1, groupAList);
        groupAList.remove(groupAList.size() - 1);

        divideDistricts(index + 1, groupAList);
    }

    private static boolean isConnected(List<Integer> groupList) {
        boolean[] visited = new boolean[N + 1];

        Deque<Integer> searchDeque = new LinkedList<>();
        searchDeque.offerLast(groupList.get(0));
        visited[groupList.get(0)] = true;

        int connectionNumber = 1;

        while (!searchDeque.isEmpty()) {
            int current = searchDeque.pollFirst();

            for (int neighbor : arrayLists.get(current)) {
                if (!visited[neighbor] && groupList.contains(neighbor)) {
                    visited[neighbor] = true;
                    searchDeque.offerLast(neighbor);
                    connectionNumber++;
                }
            }
        }

        return connectionNumber == groupList.size();
    }

    private static int getPopulationDifference(List<Integer> groupList) {
        int totalPopulation = 0;
        for (int district : groupList) totalPopulation += population[district];
        return totalPopulation;
    }
}
