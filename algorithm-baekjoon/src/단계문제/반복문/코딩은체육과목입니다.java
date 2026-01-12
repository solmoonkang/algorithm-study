package 단계문제.반복문;

import java.util.Scanner;

public class 코딩은체육과목입니다 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N / 4; i++) {
            builder.append("long").append(" ");
        }

        System.out.println(builder.append("int"));
    }
}
