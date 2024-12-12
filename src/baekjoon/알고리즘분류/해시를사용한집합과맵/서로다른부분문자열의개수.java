package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 서로다른부분문자열의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        Set<String> substringSet = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                substringSet.add(S.substring(i, j));
            }
        }

        bufferedWriter.write(String.valueOf(substringSet.size()));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
