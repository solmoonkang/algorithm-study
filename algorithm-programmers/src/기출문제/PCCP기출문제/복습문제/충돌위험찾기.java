package 기출문제.PCCP기출문제.복습문제;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 충돌위험찾기 {

    private static final int COORDINATE = 2;

    // TODO: 시작과 종료 포인트를 가져오고, 이를 활용해 충돌 가능성을 구하는 부분에 대한 이해가 부족하다. 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int point = Integer.parseInt(bufferedReader.readLine());

        int[][] points = new int[point][COORDINATE];
        for (int i = 0; i < point; i++) {
            String[] pointDirections = bufferedReader.readLine().trim().split(" ");
            points[i][0] = Integer.parseInt(pointDirections[0]);
            points[i][1] = Integer.parseInt(pointDirections[1]);
        }

        String[] routeInfo = bufferedReader.readLine().trim().split(" ");
        int route = Integer.parseInt(routeInfo[0]);
        int pointNumber = Integer.parseInt(routeInfo[1]);

        int[][] routes = new int[route][pointNumber];
        for (int i = 0; i < route; i++) {
            String[] routeDirections = bufferedReader.readLine().trim().split(" ");
            for (int j = 0; j < pointNumber; j++) {
                routes[i][j] = Integer.parseInt(routeDirections[j]);
            }
        }

        int dangerousSituationNumber = getOccurAllRobotTransportDangerousNumber(points, routes);
        bufferedWriter.write(String.valueOf(dangerousSituationNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getOccurAllRobotTransportDangerousNumber(int[][] points, int[][] routes) {
        // 각 위치 R, C와 시간 T의 조합을 KEY로 하여 해당 위치에 도착한 로봇의 수를 기록한다.
        Map<String, Integer> positionTimeMap = new HashMap<>();
        int dangerousSituationNumber = 0;

        // 현재 로봇이 이동할 시작 포인트와 종료 포인트의 좌표를 가져온다.
        for (int[] route : routes) {
            for (int i = 0; i < route.length - 1; i++) {
                int startPointIndex = route[i] - 1;
                int endPointIndex = route[i + 1] - 1;

                int startR = points[startPointIndex][0];
                int startC = points[startPointIndex][1];
                int endR = points[endPointIndex][0];
                int endC = points[endPointIndex][1];

                int currentTime = 0;
                // 현재 위치가 목표 위치에 도달할 때까지 반복한다.
                while (startR != endR || startC != endC) {
                    // 각 이동 시점에서 현재 위치(startR, startC)와 시간 currentTime을 조합한 문자열로 KEY를 만든다.
                    String positionKey = startR + "," + startC + "," + currentTime;
                    // 현재 위치와 시간의 조합을 KEY로 하여 VALUE를 증가시킨다.
                    positionTimeMap.put(positionKey, positionTimeMap.getOrDefault(positionKey, 0) + 1);

                    // 그 위치에 도착한 로봇의 수가 2 이상이면 충돌 가능성++으로, 현재 위치에 두 대 이상의 로봇이 도착했음을 의미한다.
                    if (positionTimeMap.get(positionKey) > 1) dangerousSituationNumber++;

                    // 로봇이 종료 포인트로 이동하기 위해 startR과 startC를 목표 좌표로 조정한다.
                    if (startR < endR) startR++;
                    else if (startR > endR) startR--;
                    else if (startC < endC) startC++;
                    else startC--;

                    // 현재 시간++으로 시간 경과를 반영한다.
                    currentTime++;
                }
            }
        }

        return dangerousSituationNumber;
    }
}
