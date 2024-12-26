package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 민균이의비밀번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Set<String> passwordSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String word = bufferedReader.readLine();
            passwordSet.add(word);

            String reversePassword = new StringBuilder(word).reverse().toString();
            if (passwordSet.contains(reversePassword)) {
                bufferedWriter.write(reversePassword.length() + " " + reversePassword.charAt(reversePassword.length() / 2));
                break;
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
