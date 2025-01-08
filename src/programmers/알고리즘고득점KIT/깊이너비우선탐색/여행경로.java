package programmers.알고리즘고득점KIT.깊이너비우선탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 여행경로 {

    private static final String DEPARTURE_POINT = "ICN";

    public static void main(String[] args) {
        여행경로 problem = new 여행경로();

        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println("problem = " + Arrays.toString(problem.solution(tickets1)));


        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        System.out.println("problem = " + Arrays.toString(problem.solution(tickets2)));
    }

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            else return a[1].compareTo(b[1]);
        });

        List<String> travelRouteList = new ArrayList<>();
        List<String> currentPathList = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        currentPathList.add(DEPARTURE_POINT);
        DFS(DEPARTURE_POINT, tickets, visited, currentPathList, travelRouteList);
        return travelRouteList.toArray(new String[0]);
    }

    private void DFS(String currentPath, String[][] tickets, boolean[] visited, List<String> currentPathList, List<String> travelRouteList) {
        if (currentPathList.size() == tickets.length + 1) {
            if (travelRouteList.isEmpty() || travelRouteList.get(0).compareTo(String.join(",", currentPath)) > 0) {
                travelRouteList.clear();
                travelRouteList.addAll(currentPathList);
            }

            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(currentPath)) {
                visited[i] = true;
                currentPathList.add(tickets[i][1]);
                DFS(tickets[i][1], tickets, visited, currentPathList, travelRouteList);
                visited[i] = false;
                currentPathList.remove(currentPathList.size() - 1);
            }
        }
    }
}
