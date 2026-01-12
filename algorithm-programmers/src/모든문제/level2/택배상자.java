package 모든문제.level2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 택배상자 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] order = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) order[i] = Integer.parseInt(stringTokenizer.nextToken());

        int boxes = getHowManyBoxesCarry(order);
        bufferedWriter.write(String.valueOf(boxes));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getHowManyBoxesCarry(int[] order) {
        Deque<Integer> auxiliaryContainerBelt = new ArrayDeque<>();

        // box는 컨베이어에서 오는 상자, index는 order[index]가 지금 실어야 할 상자 번호
        int box = 1, index = 0;

        // 컨테이너 벨트에서 하나씩 꺼내서 보조 벨트에 보관
        while (box <= order.length) {
            auxiliaryContainerBelt.offerLast(box);  // 처음에는 무조건 컨테이너에서 상자를 하나 꺼내서 보조 벨트에 보관

            // 보조 벨트에서 꺼낼 수 있는지 확인
            while (!auxiliaryContainerBelt.isEmpty() && auxiliaryContainerBelt.peekLast() == order[index]) {
                auxiliaryContainerBelt.pollLast();  // 트럭에 상자 적재
                index++;    // 다음 상자 번호로

                // 만약 모든 상자를 순서대로 다 실었다면 바로 종료, order 배열을 끝까지 돌았다는 의미로 order.length를 반환
                if (index == order.length) return order.length;
            }

            box++;
        }

        // 마지막 남은 보조 벨트 검사: 컨베이어에서 상자는 더 이상 안 오지만, 보조 벨트에 남아있는 상자 중에서도 기사님이 원하는 순서일 수 있어 검사
        while (!auxiliaryContainerBelt.isEmpty() && auxiliaryContainerBelt.peekLast() == order[index]) {
            auxiliaryContainerBelt.pollLast();  // 트럭에 상자 적재
            index++;    // 다음 상자 번호로
        }

        return index;
    }
}
