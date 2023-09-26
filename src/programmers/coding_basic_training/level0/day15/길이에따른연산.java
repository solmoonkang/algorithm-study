package programmers.coding_basic_training.level0.day15;

public class 길이에따른연산 {

    public int solution(int[] num_list) {

        int answer = num_list.length >= 11 ? 0 : 1;

        for (int i = 0; i < num_list.length; i++) {

            if (num_list.length >= 11) {

                answer += num_list[i];
            } else {

                answer *= num_list[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        길이에따른연산 calculate = new 길이에따른연산();

        int[] num_list1 = {3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1};
        int[] num_list2 = {2, 3, 4, 5};

        System.out.println("Result : " + calculate.solution(num_list1));
        System.out.println("Result : " + calculate.solution(num_list2));
    }
}
