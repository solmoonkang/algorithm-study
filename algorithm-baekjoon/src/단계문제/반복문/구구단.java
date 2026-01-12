package 단계문제.반복문;

import java.util.Scanner;

public class 구구단 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(N + " * " + i + " = " + N * i);
        }
    }
}
