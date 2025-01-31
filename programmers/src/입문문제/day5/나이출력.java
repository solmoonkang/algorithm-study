package 입문문제.day5;

public class 나이출력 {

    /**
     * 머쓱이는 40살인 선생님이 몇 년도에 태어났는지 궁금해졌습니다.
     * 나이 age가 주어질 때, 2022년을 기준 출생 연도를 반환하라.
     */
    public int solution(int age) {
        return 2022 - age + 1;
    }

    public static void main(String[] args) {
        나이출력 age = new 나이출력();
        System.out.println("Result: " + age.solution(40));
        System.out.println("Result: " + age.solution(23));
    }
}
