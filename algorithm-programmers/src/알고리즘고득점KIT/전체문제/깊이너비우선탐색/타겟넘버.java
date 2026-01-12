package 알고리즘고득점KIT.전체문제.깊이너비우선탐색;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class 타겟넘버 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4, 1, 2, 1};

        int target1 = 3;
        int target2 = 4;

        int wayToTargetNumber1 = solution(numbers1, target1);
        int wayToTargetNumber2 = solution(numbers2, target2);
        bufferedWriter.write(wayToTargetNumber1 + "\n" + wayToTargetNumber2);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static int solution(int[] numbers, int target) {
        return BFS(numbers, target);
    }

    // index의 역할: 현재 탐색 중인 숫자의 위치를 나타내며, 배열 numbers의 인덱스를 의미한다. 이는 탐색의 깊이를 관리하는 데 사용된다. depth라고 생각하면 된다.
    // start가 단순히 탐색을 시작하는 지점이라면, index는 현재 탐색 중인 숫자의 인덱스로 탐색이 진행될수록 증가하여 다음 숫자로 이동한다.
    private static int DFS(int[] numbers, int target, int index, int currentSum, int targetNumberCount) {
        if (index == numbers.length) {
            if (currentSum == target) targetNumberCount++;
            return targetNumberCount;
        }

        // +와 - 두 값을 모두 넣는 이유는 모든 조합을 탐색하기 위해서이다.
        // 각 숫자에 대해 두 가지 선택(덧셈과 뺄셈)을 통해 가능한 모든 조합을 탐색한다. 이를 통해 타겟 넘버를 만들 수 있는 모든 경우의 수를 확인할 수 있다.
        targetNumberCount = DFS(numbers, target, index + 1, currentSum + numbers[index], targetNumberCount);
        targetNumberCount = DFS(numbers, target, index + 1, currentSum - numbers[index], targetNumberCount);
        return targetNumberCount;
    }

    private static int BFS(int[] numbers, int target) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{0, 0});

        int targetNumberCount = 0;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            int currentSum = current[0];
            int index = current[1];

            // index가 numbers.length에 도달했을 때는 모든 숫자를 사용한 상태이다. 만약 현재 합계가 타겟과 같다면 카운트를 증가시키고, continue를 통해 다음 반복으로 넘어간다.
            // 즉, 타겟 넘버와 같더라도 그 이후에 더 이상 추가적인 처리가 필요하지 않기 떄문에 continue로 다음 반복으로 넘어간다.
            if (index == numbers.length) {
                if (currentSum == target) targetNumberCount++;
                continue;
            }

            searchDeque.offerLast(new int[]{currentSum + numbers[index], index + 1});
            searchDeque.offerLast(new int[]{currentSum - numbers[index], index + 1});
        }

        return targetNumberCount;
    }
}
