package programmers.foundation.level0.day1;

import java.util.Scanner;

public class 문자열반복해서출력하기 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        int n = scanner.nextInt();

        if (str.length() >= 1 && str.length() <= 10) {

            int i = 1;

            if (i <= 5) {

                for (i = 1; i < n+1; i++) {

                    System.out.print(str);
                }
            }
        }
    }
}
