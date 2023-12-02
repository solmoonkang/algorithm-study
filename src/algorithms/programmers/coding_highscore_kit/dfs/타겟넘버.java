package algorithms.programmers.coding_highscore_kit.dfs;

public class 타겟넘버 {

    public int solution(int[] numbers, int target) {

        // n개의 음이 아닌 정수들이 있는데, 해당 정수들의 순서를 바꾸지 않고, 적절히 더하거나 빼서 타겟 넘버를 만들려고 한다

        // 모든 가능한 뎃셈과 뺄셈의 조합을 고려해야함으로 DFS 사용이 적합하다

        return dfs(numbers, target, 0, 0);
    }

    public int dfs(int[] numbers, int target, int sum, int i) {

        if (i == numbers.length) {  // 모든 숫자들에 대해 연산 진행 완료할 경우
            if (sum == target) {    // 그 결과가 target 값과 동일할 경우
                return 1;           // 경우의 수 + 1
            }
            return 0;
        }

        int result = 0;

        result += dfs(numbers, target, sum + numbers[i], i + 1);
        result += dfs(numbers, target, sum - numbers[i], i + 1);

        return result;
    }

    public static void main(String[] args) {

        타겟넘버 targetNumber = new 타겟넘버();

        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4, 1, 2, 1};

        System.out.println("Result : " + targetNumber.solution(numbers1, 3));
        System.out.println("Result : " + targetNumber.solution(numbers2, 4));
    }
}
