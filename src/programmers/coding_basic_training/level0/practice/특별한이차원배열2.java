package programmers.coding_basic_training.level0.practice;

public class 특별한이차원배열2 {

    public int solution(int[][] arr) {

        // n × n 크기의 이차원 배열 arr 이 매개변수로 주어질 때,
        // arr 이 다음을 만족하면 1을 아니라면 0을 반환하라
        // 0 ≤ i, j < n인 정수 i, j에 대하여 arr[i][j] = arr[j][i]

        int answer = 0;

        return answer;
    }

    public static void main(String[] args) {

        특별한이차원배열2 special = new 특별한이차원배열2();

        int[][] first_arr = {{5, 192, 33}, {192, 72, 95}, {33, 95, 999}};
        int[][] second_arr = {{19, 498, 258, 587}, {63, 93, 7, 754}, {258, 7, 1000, 723}, {587, 754, 723, 81}};

        System.out.println("Result : " + special.solution(first_arr));
        System.out.println("Result : " + special.solution(second_arr));
    }
}
