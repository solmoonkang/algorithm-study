package codingTest.level0.day3_calculate;

public class 더크게합치기 {

    public int solution(int a, int b) {

        int answer1 = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int answer2 = Integer.parseInt(Integer.toString(b) + Integer.toString(a));

        if (answer1 > answer2) {
            return answer1;
        } else {
            return answer2;
        }
    }

    public static void main(String[] args) {

        더크게합치기 plus = new 더크게합치기();

        System.out.println("Result : " + plus.solution(9, 91));
        System.out.println("Result : " + plus.solution(89, 8));
    }
}
