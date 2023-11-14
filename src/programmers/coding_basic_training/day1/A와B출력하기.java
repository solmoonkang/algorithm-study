package programmers.coding_basic_training.day1;

import java.util.Scanner;

public class A와B출력하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (-100000 <= a && b <= 100000) {

            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }
    }
}
