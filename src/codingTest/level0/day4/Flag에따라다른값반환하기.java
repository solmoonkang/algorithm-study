package codingTest.level0.day4;

public class Flag에따라다른값반환하기 {

    public int solution_my(int a, int b, boolean flag) {

        int answer = 0;

        if (flag == true) {

            answer = a + b;
        } else {

            answer = a - b;
        }

        return answer;
    }

    public int solution_best(int a, int b, boolean flag) {

        return flag ? a + b : a - b;
    }

    public static void main(String[] args) {

        Flag에따라다른값반환하기 flag = new Flag에따라다른값반환하기();

        System.out.println("Result My : " + flag.solution_my(-4, 7, true));
        System.out.println("Result My : " + flag.solution_my(-4, 7, false));
        System.out.println("=====================================");

        System.out.println("Result Best : " + flag.solution_best(-4, 7, true));
        System.out.println("Result Best : " + flag.solution_best(-4, 7, false));
    }
}
