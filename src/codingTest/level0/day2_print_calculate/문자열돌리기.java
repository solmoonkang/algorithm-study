package codingTest.level0.day2_print_calculate;

import java.util.Scanner;

public class 문자열돌리기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.next();

        // spilt( ) 사용
//        String[] arr = a.split("");
//
//        if (1 <= a.length() && a.length() <= 10) {
//
//            for (String s : arr) {
//                System.out.println(s);
//            }
//        }

        // charAt( ) 사용
        if (1 <= a.length() && a.length() <= 10) {

            for (int i = 0; i < a.length(); i++) {

                System.out.println(a.charAt(i));
            }
        }
    }
}
