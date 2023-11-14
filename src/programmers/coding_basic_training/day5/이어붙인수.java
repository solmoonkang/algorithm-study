package programmers.coding_basic_training.day5;

public class 이어붙인수 {

    /**
     * num_list 의 홀수만 순서대로 이어붙인 수와
     * num_list 의 짝수만 순서대로 이어붙인 수와의 합을 출력
     */

    public int solution(int[] num_list) {

        int answer = 0;

        String even = "";       // 짝수
        String odd = "";        // 홀수

        for (int i = 0; i < num_list.length; i++) {

            // 만약, num_list 원소들 중 짝수인 경우
            if (num_list[i] % 2 == 0) {

                // toString( ) 과 valueOf( ) 의 차이점은 NPE 의 발생 유무
                // num_list 를 String 형으로 변환
                even += String.valueOf(num_list[i]);

            // 만약, num_list 원소들 중 홀수인 경우
            } else {

                // num_list 를 String 형으로 변환
                odd += String.valueOf(num_list[i]);
            }
        }

        // String 형인 짝수와 홀수를 int 형으로 변환
        answer = Integer.parseInt(even) + Integer.parseInt(odd);

        return answer;
    }

    public static void main(String[] args) {

        이어붙인수 number = new 이어붙인수();

        int[] num_list = {3, 4, 5, 2, 1};
        int[] num_list2 = {5, 7, 8, 3};

        System.out.println("Result : " + number.solution(num_list));
        System.out.println("Result : " + number.solution(num_list2));
    }
}
