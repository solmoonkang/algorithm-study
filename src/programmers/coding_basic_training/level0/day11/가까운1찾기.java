package programmers.coding_basic_training.level0.day11;

public class 가까운1찾기 {

    public int solution(int[] arr, int idx) {

        // arr의 원소는 1 또는 0으로 구성되어 있다
        // 정수 idx가 주어졌을 때, idx보다 크면서 배열의 값이 1인 가장 작은 인덱스를 찾아서 반환하라
        // ( 단, 만약 그러한 인덱스가 없다면 -1을 반환한다 )

        for (int i = idx; i < arr.length; i++) {

            if (arr[i] == 1) {

                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        가까운1찾기 near = new 가까운1찾기();

        int[] first_arr = {0, 0, 0, 1};
        int[] second_arr = {1, 0, 0, 1, 0, 0};
        int[] third_arr = {1, 1, 1, 1, 0};

        System.out.println("Result : " + near.solution(first_arr, 1));
        System.out.println("Result : " + near.solution(second_arr, 4));
        System.out.println("Result : " + near.solution(third_arr, 3));
    }
}
