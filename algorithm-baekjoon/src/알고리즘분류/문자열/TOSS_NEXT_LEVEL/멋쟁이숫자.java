package 알고리즘분류.문자열.TOSS_NEXT_LEVEL;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 멋쟁이숫자 {

    /**
     * 숫자로만 이루어진 문자열 S가 있습니다. (0 <= S.length < 1,000)
     * 아래의 조건을 모두 만족하는 숫자를 '멋쟁이 숫자'라고 합니다.
     * <p>
     * [ 조건 ]
     * 1. 길이가 3인 S의 substring을 10진수로 읽은 숫자이다.
     * 2. 각 자리의 숫자가 모두 같다.
     * <p>
     * [ 구현 사항 ]
     * 문자열 S를 입력받아 멋쟁이 숫자를 리턴하는 함수를 만들어주세요.
     * - 만약, 멋쟁이 숫자가 여러 개 존재하는 경우에는 가장 큰 수를 리턴합니다.
     * - 만약, 가장 큰 멋쟁이 숫자가 000이라면 0을 리턴합니다.
     * - 만약, 멋쟁이 숫자가 존재하지 않다면 -1을 리턴합니다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        Set<Integer> numberSet = new HashSet<>();

        for (int i = 0; i <= S.length() - 3; i++) {
            String sub = S.substring(i, i + 3);
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(1) == sub.charAt(2)) numberSet.add(Integer.parseInt(sub));
        }

        int result = -1;
        if (!numberSet.isEmpty()) result = numberSet.stream().max(Integer::compare).orElse(-1);

        bufferedWriter.write(result == 0 ? "0" : String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
