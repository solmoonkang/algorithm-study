package 알고리즘고득점KIT.복습문제.깊이_너비우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 타겟넘버 {

    /**
     * 이 문제에서 시간 복잡도는 모든 숫자에 대해 '+' 또는 '-' 부호를 선택하는 총 경우의 수에 비례한다.
     * 1. 각 숫자당 경우의 수: 각 숫자 Ni는 +1을 곱하거나 -1을 곱하는 2가지 선택지가 있다.
     * 2. 전체 경우의 수: 숫자의 개수가 N개라면, 모든 숫자가 독립적이므로 곱의 법칙에 의해 전체 경우의 수는 2^N이 된다.
     * 따라서 이 문제의 시간 복잡도는 O(2^N)이다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        int target = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        int combinations = findTargetNumberCombinations(numbers, target);
        bufferedWriter.write(String.valueOf(combinations));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int findTargetNumberCombinations(int[] numbers, int target) {
        return generateTargetNumber(numbers, target, 0, 0);
    }

    private static int generateTargetNumber(int[] numbers, int target, int depth, int currentSum) {
        // 종료 조건: 타겟에 도달하면 '1가지 방법' 반환, 타겟에 도달하지 못하면 '0가지 방법'을 반환한다.
        if (depth == numbers.length) {
            if (currentSum == target) return 1;
            return 0;
        }

        // '+'를 선택했을 때 하위 경로에서 찾은 방법의 수
        int countPlus = generateTargetNumber(numbers, target, depth + 1, currentSum + numbers[depth]);
        // '-'를 선택했을 때 하위 경로에서 찾은 방법의 수
        int countMinus = generateTargetNumber(numbers, target, depth + 1, currentSum - numbers[depth]);

        // 두 경로에서 찾은 모든 방법의 수를 합산하여 상위 호출자에게 반환한다.
        return countPlus + countMinus;
    }
}
