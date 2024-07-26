package programmers.모든문제.level1.전체문제;

public class 삼총사 {

    /**
     * [ 문제 설명 ]
     * 한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다.
     * 이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다.
     * 예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때,
     * 첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다.
     * 또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다.
     * 따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.
     * 한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때,
     * 학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.
     */
    public int solution(int[] number) {
        // 현재 원소부터 3번째 원소까지 더한 값이 0이 되는지 확인하면서 맞다면 해당 방법의 수를 증가시킨다.

        int count = 0;

        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        삼총사 theThreeMusketeers = new 삼총사();

        int[] firstNumbers = {-2, 3, 0, 2, -5};
        System.out.println("Result: " + theThreeMusketeers.solution(firstNumbers));

        int[] secondNumbers = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println("Result: " + theThreeMusketeers.solution(secondNumbers));

        int[] thirdNumbers = {-1, 1, -1, 1};
        System.out.println("Result: " + theThreeMusketeers.solution(thirdNumbers));
    }
}
