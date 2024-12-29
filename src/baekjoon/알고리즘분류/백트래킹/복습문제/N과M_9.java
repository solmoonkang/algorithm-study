package baekjoon.알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_9 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N, M;
    private static boolean[] visited;
    private static int[] numbers;
    private static int[] sequences;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N];
        numbers = new int[N];
        sequences = new int[M];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(numbers);
        generateSequences(0);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * visited 배열: 어떤 숫자가 이미 현재 수열에 포함되었는지를 추적한다. visited[i]가 true이면, numbers[i]가 현재 수열에 포함되었다는 의미이다. 이를 통해 중복된 숫자를 선택하지 않도록 방지한다.
     * 숫자가 현재 수열에 포함되었는지 엽를 추적하므로 이 배열을 사용하여 이미 선택된 숫자를 다시 선택하지 않도록 한다. 즉, visited[i]가 true인 경우, 해당 인덱스의 숫자는 이미 선택된 것이므로 더 이상 고려하지 않는다.
     * <p>
     * start 유무: 백트래킹에서 start는 다음 숫자를 선택할 때 어떤 인덱스부터 선택할지를 결정하는 데 사용된다. 이를 통해 중복된 조합을 방지할 수 있다.
     *
     * @param depth: 현재 수열의 깊이를 나타낸다. 즉, 현재까지 수열에 몇 개의 숫자가 선택되었는지를 나타내며, M개가 선택되면 수열을 완성한 것이다. depth가 M에 도달하면 수열이 완성되었으므로 결과를 저장하고 재귀 호출을 종료한다.
     */
    private static void generateSequences(int depth) {
        if (depth == M) {
            for (int number : sequences) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {

                /**
                 * (i > 0 && numbers[i] == numbers[i - 1] && !visited[i - 1]): 중복된 숫자가 연속적으로 선택되는 것을 방지한다.
                 * 1. i > 0: i가 0보다 큰 경우, 즉 numbers 배열의 첫 번째 요소를 제외한 모든 요소에 대해 조건을 확인할 수 있도록 한다. 배열의 첫 번째 요소는 비교할 이전 요소가 없기 때문에 이 조건이 필요하다.
                 * 2. numbers[i] == numbers[i - 1]: 현재 선택하려는 숫자 numbers[i]와 바로 이전 숫자 numbers[i-1]가 같은지를 확인한다. 만약 두 숫자가 같다면, 현재 숫자 numbers[i]는 중복된 숫자일 가능성이 있다.
                 * 3. !visited[i - 1]: 이전 숫자 numbers[i-1]가 선택되지 않았음을 나타낸다. 즉, visited[i-1]가 false라는 것은 numbers[i-1]가 현재 수열에 포함되어 있지 않다는 의미이다.
                 */
                if (i > 0 && numbers[i] == numbers[i - 1] && !visited[i - 1]) continue;

                visited[i] = true;
                sequences[depth] = numbers[i];
                generateSequences(depth + 1);
                visited[i] = false;
            }
        }
    }
}
