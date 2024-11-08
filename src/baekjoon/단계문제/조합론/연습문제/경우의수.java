package baekjoon.단계문제.조합론.연습문제;

import java.io.IOException;

public class 경우의수 {

    public static void main(String[] args) throws IOException {
        System.out.println("combination(3, 2) = " + combination(3, 2));
    }

    public static int combination(int N, int R) {
        if (N == R || R == 0) return 1;
        else return combination(N - 1, R - 1) + combination(N - 1, R);
    }
}
