package programmers.모든문제.level0.PCCE기출문제;

import java.util.Scanner;

public class 피타고라스의정리 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        int b_square = c * c - a * a;

        System.out.println(b_square);
    }
}
