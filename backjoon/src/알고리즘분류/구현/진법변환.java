package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 진법변환 {

    /**
     * 자바의 Integer.parseInt("문자열", 진수): 자바 내부에서 Character.digit(char, radix)라는 메서드를 통해
     * '0' ~ '9' -> 0 ~ 9, 'A' ~ 'Z', 'a' ~ 'z' -> 10 ~ 35로 매핑한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String N = stringTokenizer.nextToken();
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int decimal = Integer.parseInt(N, B);
        bufferedWriter.write(String.valueOf(decimal));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
