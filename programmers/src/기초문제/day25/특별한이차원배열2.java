package 기초문제.day25;

public class 특별한이차원배열2 {

    /**
     * [ 문제 설명 ]
     * n × n 크기의 이차원 배열 arr이 매개변수로 주어질 때,
     * arr이 0 ≤ i, j < n인 정수 i, j에 대하여 arr[i][j] = arr[j][i]을 만족하면 1을 아니라면 0을 반환하라.
     */
    public int solution(int[][] arr) {
        int answer = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    answer = 0;
                    break;
                }
            }
            // 바깥쪽 for문을 종료하기 위한 코드로, 이미 answer = 0으로 설정되었음에도 불필요한 추가 반복을 방지하기 위해 구현한다.
            if (answer == 0) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        특별한이차원배열2 special2DArray = new 특별한이차원배열2();
        int[][] firstArr = {
                {5, 192, 33},
                {192, 72, 95}, {33, 95, 999}};
        int[][] secondArr = {
                {19, 498, 258, 587}, {63, 93, 7, 754},
                {258, 7, 1000, 723}, {587, 754, 723, 81}};
        System.out.println("Result: " + special2DArray.solution(firstArr));
        System.out.println("Result: " + special2DArray.solution(secondArr));
    }
}
