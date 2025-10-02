package 모든문제.level1;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 공원산책 {

    private static final Map<Character, int[]> DIRECTION_MAP = Map.of(
            'N', new int[]{-1, 0},
            'S', new int[]{1, 0},
            'W', new int[]{0, -1},
            'E', new int[]{0, 1}
    );

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] park = new String[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            park[i] = stringTokenizer.nextToken();
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        String[] routes = new String[M];
        for (int i = 0; i < M; i++) {
            routes[i] = bufferedReader.readLine();
        }

        int[] locations = getRobotDogLocation(park, routes);
        String robotDogLocation = Arrays.stream(locations)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        bufferedWriter.write(robotDogLocation);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getRobotDogLocation(String[] park, String[] routes) {
        int[] startLocations = findStartLocation(park);
        int currentY = startLocations[0];
        int currentX = startLocations[1];

        for (String route : routes) {
            String[] commands = route.split(" ");
            char operator = commands[0].charAt(0);
            int distance = Integer.parseInt(commands[1]);

            int[] delta = DIRECTION_MAP.get(operator);
            int dY = delta[0];
            int dX = delta[1];

            boolean canMove = true;

            int nextY = currentY;
            int nextX = currentX;

            for (int i = 1; i <= distance; i++) {
                nextY += dY;
                nextX += dX;

                if (nextY < 0 || nextY >= park.length || nextX < 0 || nextX >= park[0].length()) {
                    canMove = false;
                    break;
                }

                if (park[nextY].charAt(nextX) == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                currentY = nextY;
                currentX = nextX;
            }
        }

        return new int[]{currentY, currentX};
    }

    private static int[] findStartLocation(String[] park) {
        for (int y = 0; y < park.length; y++) {
            for (int x = 0; x < park[y].length(); x++) {
                if (park[y].charAt(x) == 'S') {
                    return new int[]{y, x};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
