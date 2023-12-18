package algorithms.programmers.coding_all_problem.level1.practiceproblems;

public class 서울에서김서방찾기 {

    /**
     * [ 문제 설명 ]
     * String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요.
     * 단, seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
     */
    public String solution(String[] seoul) {
        int position = 0;

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                position = i;
            }
        }
        return "김서방은 " + position + "에 있다";
    }

    public static void main(String[] args) {
        서울에서김서방찾기 findingKimInSeoul = new 서울에서김서방찾기();
        String[] seoul = {"Jane", "Kim"};
        System.out.println("Result: " + findingKimInSeoul.solution(seoul));
    }
}
