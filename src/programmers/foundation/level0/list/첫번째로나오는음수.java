package programmers.foundation.level0.list;

public class 첫번째로나오는음수 {

    public int solution(int[] num_list) {

        int answer = 0;

        boolean hasNegative = false;

        for (int i = 0; i < num_list.length; i++) {

            // 만약, 배열 내부에 음수가 있을 경우
            if (num_list[i] < 0) {

                // answer 에 해당 음수의 인덱스 값을 저장
                answer = i;

                // 음수가 있으면 해당 boolean 값을 true 로 설정
                hasNegative = true;

                // 뒤쪽의 요소들의 검색을 중단
                break;
            }
        }

        // 만약, 음수가 없을 경우
        if (!hasNegative) {

            // answer 에 -1 을 저장
            answer = -1;
        }

        return answer;
    }

    public static void main(String[] args) {

        첫번째로나오는음수 negative = new 첫번째로나오는음수();

        int[] num_list1 = {12, 4, 15, 46, 38, -2, 15};
        int[] num_list2 = {13, 22, 53, 24, 15, 6};

        System.out.println("Negative Number : " + negative.solution(num_list1));
        System.out.println("Negative Number : " + negative.solution(num_list2));
    }
}
