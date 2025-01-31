package 모든문제.level0.코딩테스트입문;

import java.util.Arrays;

public class 겹치는선분의길이 {

    // TODO: 점의 개수를 세어서 겹치는 선분의 길이를 구하는 방식 실패, 현재 방법으로 했을 때 3번째 예시를 통과하지 못함.
    public int solution(int[][] lines) {
        Arrays.sort(lines, (a, b) -> Integer.compare(a[0], b[0]));

        int totalOverlap = 0;
        int currentStart = lines[0][0];
        int currentEnd = lines[0][1];

        for (int i = 1; i < lines.length; i++) {
            int nextStart = lines[i][0];
            int nextEnd = lines[i][1];

            if (nextStart < currentEnd) {
                totalOverlap += Math.max(0, Math.min(currentEnd, nextEnd) - nextStart);
                currentEnd = Math.max(currentEnd, nextEnd);
            } else {
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        return totalOverlap;
    }

    public static void main(String[] args) {
        겹치는선분의길이 lengthOfOverlappingSegments = new 겹치는선분의길이();

        int[][] lines1 = {{0, 1}, {2, 5}, {3, 9}};
        System.out.println("lengthOfOverlappingSegments = " + lengthOfOverlappingSegments.solution(lines1));

        int[][] lines2 = {{-1, 1}, {1, 3}, {3, 9}};
        System.out.println("lengthOfOverlappingSegments = " + lengthOfOverlappingSegments.solution(lines2));

        int[][] lines3 = {{0, 5}, {3, 9}, {1, 10}};
        System.out.println("lengthOfOverlappingSegments = " + lengthOfOverlappingSegments.solution(lines3));
    }
}
