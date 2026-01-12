package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class ACM호텔 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int H = Integer.parseInt(stringTokenizer.nextToken());
            int W = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());

            String roomNumber = assignedRoomNumberToGuest(H, W, N);
            bufferedWriter.write(roomNumber + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String assignedRoomNumberToGuest(int totalFloors, int roomsPerFloor, int guestNumber) {
        int floor = guestNumber % totalFloors;
        int room = guestNumber / totalFloors;

        // 만약, 손님 번호가 전체 층수의 배수라면 나머지 연산을 했을 때, 층수 0층이 되어버리므로, 나머지가 0이면 맨 꼭대기 층을 의미한다.
        if (floor == 0) floor = totalFloors;

        // 나머지가 있으면 평범하게 계산이 된 경우를 의미한다.
        room += 1;

        return floor + String.format("%02d", room);
    }
}
