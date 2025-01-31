package 기초문제.day15;

public class 일로만들기 {

    public int solution(int[] num_list) {

        // 정수가 있을 때, 짝수라면 반으로 나누고, 홀수라면 1을 뺸 뒤 반으로 나누면, 마지막엔 1이 된다
        // num_list 의 모든 원소를 1로 만들기 위해서 필요한 나누기 연산의 횟수를 반환하라

        int answer = 0;

        for (int num : num_list) {

            while (num != 1) {

                if (num % 2 == 0) {

                    num /= 2;

                } else if (num % 2 == 1) {

                    num = (num - 1) / 2;

                }

                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        일로만들기 makeIt1 = new 일로만들기();

        int[] num_list = {12, 4, 15, 1, 14};

        System.out.println("Result : " + makeIt1.solution(num_list));
    }
}
