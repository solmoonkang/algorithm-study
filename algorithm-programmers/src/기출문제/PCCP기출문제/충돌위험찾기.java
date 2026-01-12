package 기출문제.PCCP기출문제;

import java.util.HashMap;
import java.util.Map;

public class 충돌위험찾기 {

    // TODO: 각 로봇이 같은 위치를 여러 번 방문했을 때 충돌 수를 제대로 체크하지 못하고 있다.
    public int solution(int[][] points, int[][] routes) {
        int dangerousSituationsOccur = 0;
        Map<String, Integer> positionCountMap = new HashMap<>();

        for (int[] route : routes) moveRobot(points, route, positionCountMap);

        for (int count : positionCountMap.values()) {
            if (count > 1) dangerousSituationsOccur += count - 1;
        }

        return dangerousSituationsOccur;
    }

    private void moveRobot(int[][] points, int[] route, Map<String, Integer> positionCountMap) {
        int startPointIndex = route[0] - 1;
        int[] currentPosition = points[startPointIndex];

        for (int i = 1; i < route.length; i++) {
            int[] nextPosition = points[route[i] - 1];
            moveDirection(currentPosition, nextPosition, positionCountMap);
            currentPosition = nextPosition;
        }
    }

    private void moveDirection(int[] currentPosition, int[] nextPosition, Map<String, Integer> positionCountMap) {
        int x = currentPosition[0];
        int y = currentPosition[1];

        while (x != nextPosition[0]) {
            if (x < nextPosition[0]) x++;
            else x--;
            recordPosition(x, y, positionCountMap);
        }

        while (y != nextPosition[1]) {
            if (y < nextPosition[1]) y++;
            else y--;
            recordPosition(x, y, positionCountMap);
        }
    }

    private void recordPosition(int x, int y, Map<String, Integer> positionCountMap) {
        String positionKey = x + "," + y;
        positionCountMap.put(positionKey, positionCountMap.getOrDefault(positionKey, 0) + 1);
    }

    public static void main(String[] args) {
        충돌위험찾기 problem = new 충돌위험찾기();

        int[][] points1 = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes1 = {{4, 2}, {1, 3}, {2, 4}};
        System.out.println("problem = " + problem.solution(points1, routes1));


        int[][] points2 = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes2 = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};
        System.out.println("problem = " + problem.solution(points2, routes2));


        int[][] points3 = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        int[][] routes3 = {{2, 3, 4, 5}, {1, 3, 4, 5}};
        System.out.println("problem = " + problem.solution(points3, routes3));
    }
}
