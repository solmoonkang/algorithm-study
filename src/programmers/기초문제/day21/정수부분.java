package programmers.기초문제.day21;

public class 정수부분 {

    public int solution(double flo) {

        return (int) Math.abs(flo);
    }

    public static void main(String[] args) {

        정수부분 integer = new 정수부분();

        System.out.println("Result : " + integer.solution(1.42));
        System.out.println("Result : " + integer.solution(69.32));
    }
}
