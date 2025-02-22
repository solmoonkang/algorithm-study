package 알고리즘분류.구현;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 지능형기차 {

    private static final int TERMINUS = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] passengers = new int[TERMINUS][2];

        for (int i = 0; i < TERMINUS; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            passengers[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            passengers[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxPassengerWithDeque = calculateMaxPassengerWithDeque(passengers);

        int maxPassengerImproved = calculateMaxPassengerImproved(passengers);

        bufferedWriter.write("덱을 사용한 풀이 방식: " + maxPassengerWithDeque + "\n");
        bufferedWriter.write("개선된 풀이 방식: " + maxPassengerImproved + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 각 역에서 승객 수를 순차적으로 계산하면서 최대값만 구하면 되므로, Deque를 사용하여 불필요한 메모리 사용과 시간 복잡도를 증가시킬 필요가 없다.
    // 또한, Deque에 동일한 값을 두 번 추가하고 Deque에 저장된 모든 값을 순회하면서 최대값을 찾아 불필요한 계산이 이루어진다.
    private static int calculateMaxPassengerWithDeque(int[][] passengers) {
        Deque<Integer> searchDeque = new LinkedList<>();

        for (int[] passenger : passengers) {
            int gettingOff = passenger[1] - passenger[0];

            if (!searchDeque.isEmpty()) {
                int remainPassenger = searchDeque.peekFirst();
                searchDeque.offerLast(gettingOff + remainPassenger);
            }

            searchDeque.offerLast(gettingOff);
        }

        int maxPassenger = 0;
        for (int passenger : searchDeque) maxPassenger = Math.max(maxPassenger, passenger);

        return maxPassenger;
    }

    private static int calculateMaxPassengerImproved(int[][] passengers) {
        int currentPassengers = 0;
        int maxPassengers = 0;

        for (int[] passenger : passengers) {
            currentPassengers -= passenger[0];
            currentPassengers += passenger[1];
            maxPassengers = Math.max(maxPassengers, currentPassengers);
        }

        return maxPassengers;
    }
}
