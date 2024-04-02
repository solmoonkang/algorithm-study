package programmers.입문문제.day7;

public class 각도기 {

    /**
     * 각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류합니다.
     * 각 angle이 매개변수로 주어질 때 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 반환하라.
     */
    public int solution(int angle) {
        if (0 < angle && angle < 90) {
            return 1;
        } else if (angle == 90) {
            return 2;
        } else if (90 < angle && angle < 180) {
            return 3;
        }
        return 4;
    }

    public static void main(String[] args) {
        각도기 protractor = new 각도기();
        System.out.println("Result: " + protractor.solution(70));
        System.out.println("Result: " + protractor.solution(91));
        System.out.println("Result: " + protractor.solution(180));
    }
}
