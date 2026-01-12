package 알고리즘분류.두포인터.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 두포인터의합과차 {

    /**
     * 두 포인터의 합과 차: 배열이나 리스트에서 두 개의 포인터를 사용하여 합이나 차를 계산하는 문제를 해결한다.
     * - 보통 왼쪽 포인터와 오른쪽 포인터를 사용하며, 이들은 각각 탐색 범위의 시작과 끝을 가리킨다.
     * - 이 유형은 두 요소의 합이나 차가 주어진 값과 일치하는지 확인하는 등의 문제에 사용될 수 있다.
     */

    /**
     * 문제 유형: 두 수의 합이 X인 쌍이 있는가? 혹은 두 수의 차가 K인 쌍이 있는가?에 사용된다.
     * 핵심 아이디어: 정렬된 배열을 활용해서 두 포인터를 양 끝에서 움직이거나 앞뒤로 움직이며 차이를 조정한다.
     */

    private static final String PAIR_EXISTS = "YES";
    private static final String PAIR_NOT_EXISTS = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] sequences = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int target = Integer.parseInt(stringTokenizer.nextToken());
        int difference = Integer.parseInt(stringTokenizer.nextToken());

        bufferedWriter.write(hasPairWithSum(sequences, target) ? PAIR_EXISTS + "\n" : PAIR_NOT_EXISTS + "\n");
        bufferedWriter.write(hasPairWithDifference(sequences, difference) ? PAIR_EXISTS + "\n" : PAIR_NOT_EXISTS + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean hasPairWithSum(int[] sequences, int target) {
        int left = 0, right = sequences.length - 1;

        while (left < right) {
            int sum = sequences[left] + sequences[right];
            if (sum == target) return true;
            else if (sum < target) left++;
            else right--;
        }

        return false;
    }

    private static boolean hasPairWithDifference(int[] sequences, int difference) {
        int left = 0, right = 1;

        while (right < sequences.length) {
            int gap = sequences[right] - sequences[left];

            if (left == right || gap < difference) right++;
            else if (gap > difference) left++;
            else return true;
        }

        return false;
    }
}
