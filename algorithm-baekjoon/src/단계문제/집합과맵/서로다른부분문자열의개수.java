package 단계문제.집합과맵;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 서로다른부분문자열의개수 {

    // TODO: 큰 입력에 대한 성능이 떨어질 수 있다. 때문에 StringBuilder를 활용하여 substring 호출에 따른 메모리 사용량을 줄여보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        Set<String> partialStringSet = new HashSet<>();

        for (int start = 0; start < S.length(); start++) {
            for (int end = start; end < S.length(); end++) {
                partialStringSet.add(S.substring(start, end + 1));
            }
        }

        bufferedWriter.write(String.valueOf(partialStringSet.size()));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
