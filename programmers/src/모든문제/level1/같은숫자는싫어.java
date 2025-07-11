package 모든문제.level1;

import java.io.*;
import java.util.*;

public class 같은숫자는싫어 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] distinctNumbers = getDistinctNumbers(numbers);
        for (int number : distinctNumbers) bufferedWriter.write(number + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getDistinctNumbers(int[] numbers) {
        // 순서를 따진다면 Set 자료구조는 적합하지 않고, Deque를 활용하는 것이 더 좋을 것 같다.
        // 플로우: 덱이 비어있다면 값을 무조건 넣는다 -> 덱이 비어있지 않다면 가장 마지막에 들어있는 값과 현재 값을 비교하고 같다면 넘어가고 다르면 값을 넣는다

        Deque<Integer> distinctNumbers = new ArrayDeque<>();

        for (int number : numbers) {
            if (!distinctNumbers.isEmpty()) {
                if (distinctNumbers.peekLast() == number) continue;
            }

            distinctNumbers.offerLast(number);
        }

        return distinctNumbers.stream().mapToInt(i -> i).toArray();
    }
}
