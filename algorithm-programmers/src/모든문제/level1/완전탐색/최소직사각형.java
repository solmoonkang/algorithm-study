package 모든문제.level1.완전탐색;

public class 최소직사각형 {

    // TODO: 처음 문제를 풀 때, 너무 어렵게 생각해서 꼬였음. 조금 더 쉽게 바라보고 생각해보자.
    public int solution(int[][] sizes) {
        int maximumWidth = 0;
        int maximumHeight = 0;

        for (int i = 0; i < sizes.length; i++) {
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);

            maximumWidth = Math.max(maximumWidth, width);
            maximumHeight = Math.max(maximumHeight, height);
        }

        return maximumWidth * maximumHeight;
    }

    public static void main(String[] args) {
        최소직사각형 minimumRectangle = new 최소직사각형();

        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println("minimumRectangle = " + minimumRectangle.solution(sizes1));

        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println("minimumRectangle = " + minimumRectangle.solution(sizes2));

        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println("minimumRectangle = " + minimumRectangle.solution(sizes3));
    }
}
