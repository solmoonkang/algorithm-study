package programmers.foundation.level0.day1;

import java.util.Scanner;

public class 대소문자바꿔서출력하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.next();

        String answer = "";

        if (1 <= a.length() && a.length() <= 20 ) {

            for (int i = 0; i < a.length(); i++) {

                char c = a.charAt(i);

                if (Character.isLowerCase(c)) {
                    answer += Character.toUpperCase(c);
                } else {
                    answer += Character.toLowerCase(c);
                }
            }
        }

        System.out.println(answer);
    }
}
