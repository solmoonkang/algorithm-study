package 단계문제.조합론.연습문제;

public class 백트래킹과재귀 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        boolean[] visited = new boolean[numbers.length];

        System.out.println("===== 1. 백트래킹을 이용한 구현 =====");
        for (int R = 1; R <= numbers.length; R++) {
            System.out.println("\n" + numbers.length + "개 중에 " + R + "개를 뽑았습니다.");
            combination1(numbers, visited, 0, R);
        }

        System.out.println("===== 2. 재귀를 이용한 구현 =====");
        for (int R = 1; R <= numbers.length; R++) {
            System.out.println("\n" + numbers.length + "개 중에 " + R + "개를 뽑았습니다.");
            combination2(numbers, visited, 0, R);
        }
    }

    public static void combination1(int[] numbers, boolean[] visited, int start, int R) {
        if (R == 0) print(numbers, visited);
        else {
            for (int i = start; i < numbers.length; i++) {
                visited[i] = true;
                combination1(numbers, visited, i + 1, R - 1);
                visited[i] = false;
            }
        }
    }

    public static void combination2(int[] numbers, boolean[] visited, int depth, int R) {
        if (R == 0) print(numbers, visited);

        if (depth == numbers.length) return;
        else {
            visited[depth] = true;
            combination2(numbers, visited, depth + 1, R = 1);

            visited[depth] = false;
            combination2(numbers, visited, depth + 1, R);
        }
    }

    public static void print(int[] numbers, boolean[] visited) {
        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) System.out.println("numbers element = " + numbers[i]);
        }

        System.out.println();
    }
}
