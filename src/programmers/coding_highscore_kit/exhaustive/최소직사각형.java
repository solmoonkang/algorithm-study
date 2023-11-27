package programmers.coding_highscore_kit.exhaustive;

public class 최소직사각형 {

    /**
     * 명합 지갑을 만드는 회사에서 지갑의 크기를 정하려고 한다
     * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 반환하라
     */
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

        최소직사각형 rectangle = new 최소직사각형();

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println("Result : " + rectangle.solution(sizes));
    }
}
