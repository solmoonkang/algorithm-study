package algorithms.programmers.coding_basic_training.day14;

public class 홀수vs짝수 {

    public int solution(int[] num_list) {

        // 정수 리스트 num_list 가 주어집니다.
        // 가장 첫 번째 원소를 1번 원소라고 할 때, 홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을 return 하도록 solution 함수를 완성해주세요.
        // 두 값이 같을 경우 그 값을 return 합니다.

        int even = 0;
        int sum = 0;

        for (int i = 0; i < num_list.length; i++) {

            sum += num_list[i];
        }

        for (int i = 0; i < num_list.length; i+=2) {

            even += num_list[i];
        }

        int odd = sum - even;

        if (even > odd) {

            return even;

        } else if (odd > even) {

            return odd;

        } else {

            return even;

        }
    }

    public static void main(String[] args) {

        홀수vs짝수 oddVSeven = new 홀수vs짝수();

        int[] first_num_list = {4, 2, 6, 1, 7, 6};
        int[] second_num_list = {-1, 2, 5, 6, 3};

        System.out.println("Result : " + oddVSeven.solution(first_num_list));
        System.out.println("Result : " + oddVSeven.solution(second_num_list));
    }
}
