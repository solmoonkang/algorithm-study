package 모든문제.level2;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 방문길이 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String dirs = bufferedReader.readLine();

        int pathLength = getCharacterWalksFirstTime(dirs);
        bufferedWriter.write(String.valueOf(pathLength));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getCharacterWalksFirstTime(String dirs) {
        // 중복 없이 지나간 길을 저장하기 위한 Set 자료구조를 선언한다.
        Set<String> visited = new HashSet<>();

        // 캐릭터의 처음 시작 좌표를 저장한다.
        int x = 0, y = 0;

        Map<Character, int[]> directions = Map.of(
                'U', new int[]{0, 1},
                'D', new int[]{0, -1},
                'L', new int[]{-1, 0},
                'R', new int[]{1, 0}
        );

        for (char command : dirs.toCharArray()) {
            int dx = directions.get(command)[0];    // x 방향 이동량
            int dy = directions.get(command)[1];    // y 방향 이동량

            int nx = x + dx;    // 이동 후 x좌표
            int ny = y + dy;    // 이동 후 y좌표

            // 이동한 좌표가 범위를 벗어나면 무시한다.
            if (nx < -5 || nx >= 5 || ny < -5 || ny >= 5) continue;

            // 현재 위치 -> 다음 위치 경로 문자열을 저장한다.
            String path = x + "," + y + ":" + nx + "," + ny;
            // 다음 위치 -> 현재 위치 (역방향) 경로 문자열을 저장한다.
            String reversePath = nx + "," + ny + ":" + x + "," + y;

            // 방문한 길을 저장한다.
            visited.add(path);
            visited.add(reversePath);

            // 현재 좌표를 갱신하여 캐릭터의 실제 이동을 나타낸다.
            x = nx;
            y = ny;
        }

        // 양방향을 각각 저장했으므로 실제 경로 수는 절반으로 반환한다.
        return visited.size() / 2;
    }
}
