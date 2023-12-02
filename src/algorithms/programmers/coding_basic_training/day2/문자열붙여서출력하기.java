package algorithms.programmers.coding_basic_training.day2;

import java.util.Scanner;

public class 문자열붙여서출력하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        String result = a.trim() + b.trim();

        System.out.println(result);
    }
}
