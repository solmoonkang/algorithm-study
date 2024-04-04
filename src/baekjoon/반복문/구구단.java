package baekjoon.반복문;

public class 구구단 {

    // N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.

    public static void main(String[] args) {
        int N = 2;

        for (int i = 1; i <= 9; i++) {
            System.out.println(N + " * " + i + " = " + N * i);
        }
        System.out.println();
    }
}
