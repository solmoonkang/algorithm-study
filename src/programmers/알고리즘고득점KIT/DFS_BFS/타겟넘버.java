package programmers.알고리즘고득점KIT.DFS_BFS;

public class 타겟넘버 {

    private int count = 0;

    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return count;
    }

    private void DFS(int[] numbers, int target, int index, int currentSum) {
        if (index == numbers.length) {
            if (currentSum == target) count++;
            return;
        }

        DFS(numbers, target, index + 1, currentSum + numbers[index]);
        DFS(numbers, target, index + 1, currentSum - numbers[index]);
    }

    public static void main(String[] args) {
        타겟넘버 targetNumber = new 타겟넘버();

        int[] numbers1 = {1, 1, 1, 1, 1};
        System.out.println("targetNumber = " + targetNumber.solution(numbers1, 3));

        int[] numbers2 = {4, 1, 2, 1};
        System.out.println("targetNumber = " + targetNumber.solution(numbers2, 4));
    }
}
