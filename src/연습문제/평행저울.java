package 연습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 평행저울 {

    private static final int[] WEIGHTS = {1, 3, 7, 26, 38, 57};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        String addingWeights = buildByAddingWeights(N);
        bufferedWriter.write(addingWeights + "\n");

        bufferedWriter.write("=====");
        bufferedWriter.newLine();

        String balancedScale = solveByBalancedScale(N);
        bufferedWriter.write(balancedScale);
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * - N += weight로 원래의 입력값 N이 훼손되어 의미 전달이 명확하지 않다.
     * - 추의 합이 맞지 않아도 무조건 계속 더하여 브레이크 조건이 우연에 의존한다.
     * - else if (N == weight)에서만 정답 조건을 판단하여 완전히 딱 맞는 경우가 아니면 실패한다.
     * - 왼쪽 추만 사용, 오른쪽 추는 조건 매칭일 뿐 명시적 선택이 아니다.
     */
    private static String buildByAddingWeights(int N) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(N).append(" ");

        for (int weight : WEIGHTS) {
            if (N != weight) {
                stringBuilder.append(weight).append(" ");
                N += weight;
            } else {
                stringBuilder.append("0").append(" ").append(weight);
                break;
            }
        }

        return stringBuilder.toString();
    }

    /**
     * - 우측 추 하나를 가정하고, 좌측 추 조합을 만들어 맞추는 구조이다.
     * - leftSum = N을 유지하며 += 추 를 반복하여 물건 + 추 = 우측 추의 구조를 유지한다.
     * - 조합이 되는 순간 break로 필요 이상의 계산 없이 즉시 종료한다.
     * - leftList, right 추가 명확히 구분되어 출력 형식과 로직이 1:1 매핑된다.
     */
    private static String solveByBalancedScale(int N) {
        List<Integer> leftList = new ArrayList<>();
        int leftSum = 0;
        boolean found = false;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < WEIGHTS.length; i++) {
            leftList.clear();
            leftSum = N;

            for (int j = 0; j < WEIGHTS.length; j++) {
                if (j == i) continue;

                if (leftSum + WEIGHTS[j] <= WEIGHTS[i]) {
                    leftList.add(WEIGHTS[j]);
                    leftSum += WEIGHTS[j];
                }

                if (leftSum == WEIGHTS[i]) {
                    found = true;
                    break;
                }
            }

            if (found) {
                stringBuilder.append(N).append(" ");
                for (int weight : leftList) stringBuilder.append(weight).append(" ");
                stringBuilder.append("0").append(" ").append(WEIGHTS[i]);
                break;
            }
        }

        return stringBuilder.toString();
    }
}
