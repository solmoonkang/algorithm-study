package 모든문제.level1.전체문제;

import java.util.Arrays;

public class 공원산책 {

    /**
     * 공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes
     * [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성
     *
     * park[i]는 다음 문자들로 이루어져 있으며 시작지점은 하나만 주어진다.
     * S : 시작 지점
     * O : 이동 가능한 통로
     * X : 장애물
     *
     * routes의 원소는 "op n"과 같은 구조로 이루어져 있으며, op는 이동할 방향, n은 이동할 칸의 수를 의미합니다.
     * N : 북쪽으로 주어진 칸만큼 이동합니다.
     * S : 남쪽으로 주어진 칸만큼 이동합니다.
     * W : 서쪽으로 주어진 칸만큼 이동합니다.
     * E : 동쪽으로 주어진 칸만큼 이동합니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 초기 위치 찾기: 먼저 park 배열에서 로봇 강아지의 시작 위치 'S'를 찾아야 합니다. 이 위치는 로봇 강아지의 현재 위치로 설정됩니다.
     *
     * 2. 명령어 처리: routes 배열의 각 원소를 순차적으로 처리합니다.
     * 각 원소는 "방향 거리" 형식으로 되어 있으며, 이를 분석하여 로봇 강아지가 이동할 방향과 거리를 파악합니다.
     *
     * 3. 이동 가능성 검사:
     * 공원 범위 검사: 로봇 강아지가 이동하려는 거리가 공원의 범위를 벗어나는지 확인합니다. 만약 벗어난다면, 해당 명령은 무시합니다.
     * 장애물 검사: 이동 경로상에 'X'로 표시된 장애물이 있는지 확인합니다. 만약 장애물이 있다면, 해당 명령도 무시합니다.
     *
     * 4. 이동 실행: 위의 검사를 통과하면, 로봇 강아지는 해당 명령에 따라 이동합니다. 이동 후의 위치를 현재 위치로 업데이트합니다.
     *
     * 5. 최종 위치 반환: 모든 routes의 명령을 처리한 후, 로봇 강아지의 최종 위치를 [세로 방향 좌표, 가로 방향 좌표] 형식으로 반환합니다.
     */
    public int[] solution(String[] park, String[] routes) {
        // TODO: 그래프나 방향과 관련된 문제가 나오면 많이 어려워함. 다양한 문제를 더 풀어보자.
        int[] position = new int[2];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    position[0] = i;
                    position[1] = j;
                    break;
                }
            }
        }

        for (String route : routes) {
            String[] command = route.split(" ");
            char direction = command[0].charAt(0);
            int distance = Integer.parseInt(command[1]);

            int x = position[1];
            int y = position[0];

            int startX = x;
            int startY = y;

            for (int i = 0; i < distance; i++) {
                switch (direction) {
                    case 'N': y--; break;
                    case 'S': y++; break;
                    case 'W': x--; break;
                    case 'E': x++; break;
                }

                if (y < 0 || y >= park.length || x < 0 || x >= park[0].length() || park[y].charAt(x) == 'X') {
                    x = startX;
                    y = startY;
                    break;
                }
            }
            position[0] = y;
            position[1] = x;
        }

        return position;
    }

    public static void main(String[] args) {
        공원산책 walkPark = new 공원산책();

        String[] firstPark = {"SOO","OOO","OOO"};
        String[] firstRoutes = {"E 2","S 2","W 1"};
        System.out.println("walkPark = " +
                Arrays.toString(walkPark.solution(firstPark, firstRoutes)));

        String[] secondPark = {"SOO","OXX","OOO"};
        String[] secondRoutes = {"E 2","S 2","W 1"};
        System.out.println("walkPark = " +
                Arrays.toString(walkPark.solution(secondPark, secondRoutes)));

        String[] thirdPark = {"OSO","OOO","OXO","OOO"};
        String[] thirdRoutes = {"E 2","S 3","W 1"};
        System.out.println("walkPark = " +
                Arrays.toString(walkPark.solution(thirdPark, thirdRoutes)));
    }
}
