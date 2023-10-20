package programmers.coding_basic_training.level0.day23;

public class 정수찾기 {

    public int solution(int[] num_list, int n) {

        // num_list 안에 n이 있으면 1을    없으면 0을 반환하라

        int answer = 0;

        for (int i = 0; i < num_list.length; i++) {

            if (num_list[i] == n) {

                answer = 1;

            }
        }

        return answer;
    }

    public static void main(String[] args) {

        정수찾기 number = new 정수찾기();

        int[] num_list1 = {1, 2, 3, 4, 5};
        int[] num_list2 = {15, 98, 23, 2, 15};

        System.out.println("Result : " + number.solution(num_list1, 3));
        System.out.println("Result : " + number.solution(num_list2, 20));
    }
}
