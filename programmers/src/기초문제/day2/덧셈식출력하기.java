package 기초문제.day2;

import java.util.Scanner;

public class 덧셈식출력하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = a + b;

        System.out.println(a + " + " + b + " = " + result);
    }
}
