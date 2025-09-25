package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;

public class 키패드누르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        String hand = bufferedReader.readLine();

        String thumbs = getIndicatingWhichThumb(numbers, hand);
        bufferedWriter.write(thumbs);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String getIndicatingWhichThumb(int[] numbers, String hand) {
        // 현재 왼손 위치를 추적하기 위한 변수로 * 키를 10으로 매핑
        int leftIndex = 10;
        // 현재 오른손 위치를 추적하기 위한 변수로 # 키를 12로 매핑
        int rightIndex = 12;

        StringBuilder stringBuilder = new StringBuilder();

        for (int targetNumber : numbers) {
            // 키패드 1, 4, 7이 나온다면 현재 왼손 위치를 최신화하고, StringBuilder에 L을 추가
            if (targetNumber == 1 || targetNumber == 4 || targetNumber == 7) {
                leftIndex = targetNumber;
                stringBuilder.append("L");
            }
            // 키패드 3, 6, 9가 나온다면 현재 오른손 위치를 최신화하고, StringBuilder에 R을 추가
            else if (targetNumber == 3 || targetNumber == 6 || targetNumber == 9) {
                rightIndex = targetNumber;
                stringBuilder.append("R");
            }
            // 키패드 2, 5, 8, 0이 나온다면 어떤 손이 움직일지 계산
            else {
                // 왼손 거리 계산
                int leftDistance = calculateDistance(leftIndex, targetNumber);
                // 오른손 거리 계산
                int rightDistance = calculateDistance(rightIndex, targetNumber);

                // 두 거리가 다른 경우
                if (leftDistance < rightDistance) {
                    leftIndex = targetNumber;
                    stringBuilder.append("L");
                } else if (leftDistance > rightDistance) {
                    rightIndex = targetNumber;
                    stringBuilder.append("R");
                }

                // 두 거리가 같은 경우
                else {
                    // 왼손잡이일 경우
                    if (hand.equals("left")) {
                        leftIndex = targetNumber;
                        stringBuilder.append("L");
                    }

                    // 오른손잡이일 경우
                    else {
                        rightIndex = targetNumber;
                        stringBuilder.append("R");
                    }
                }
            }
        }

        return stringBuilder.toString();
    }

    private static int calculateDistance(int from, int to) {
        int[] fromCoords = getCoords(from);
        int[] toCoords = getCoords(to);

        return Math.abs(fromCoords[0] - toCoords[0]) + Math.abs(fromCoords[1] - toCoords[1]);
    }

    // 전화 키패드를 컴퓨터가 이해할 수 있도록 2차원 좌표(행, 열)로 변환해주는 함수
    private static int[] getCoords(int number) {
        // 특수키 처리를 위해 *은 10으로, #은 12로 정의
        if (number == 10) return new int[]{3, 0};
        if (number == 0) return new int[]{3, 1};
        if (number == 12) return new int[]{3, 2};

        // 1, 2, 3은 모두 0번째 행에, 4, 5, 6은 모두 1번째 행에, 7, 8, 9는 모두 2번째 행에 위치하므로 패턴을 일반화하면 /3을 사용
        int row = (number - 1) / 3;
        // 1, 4, 7은 모두 0번째 열에, 2, 5, 8은 모두 1번째 행에, 3, 6, 9는 모두 2번째 열에 위치하므로 패턴을 일반화하면 %3을 사용
        int col = (number - 1) % 3;

        return new int[]{row, col};
    }
}
