package programmers.모든문제.level1.알고리즘고득점KIT;

public class 최소직사각형 {

    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;

        for (int[] size : sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);

            width = Math.max(width, max);
            height = Math.max(height, min);
        }

        return width * height;
    }

    public static void main(String[] args) {
        최소직사각형 problem = new 최소직사각형();

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println("problem = " + problem.solution(sizes));
    }
}
