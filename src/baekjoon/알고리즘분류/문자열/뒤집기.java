package baekjoon.알고리즘분류.문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 뒤집기 {

    /**
     * reverseBinary( ): 문자열의 한 번 순회하기 떄문에, 문자열의 길이 N만큼 걸리므로 O(N)의 시간 복잡도를 갖는다.
     * reverseBinaryInList( ): 문자열을 두 번 순회하고, 각각의 리스트를 생성하기 위해 추가적인 순회가 필요하여 O(N + M + K)의 시간 복잡도를 갖는다.
     *  - 여기서 M과 K는 각각 "0"으로 나누어진 부분의 수와 "1"로 나누어진 부분의 수이다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = bufferedReader.readLine();

        int minReverseBinaryStringInList = reverseBinaryInList(S);
        bufferedWriter.write(String.valueOf(minReverseBinaryStringInList));
        bufferedWriter.newLine();

        int minReverseBinaryString = reverseBinary(S);
        // 전환된 그룹 수를 2로 나누는 이유는 최소 뒤집기 작업 수를 계산하기 위해서이다.
        // 각 그룹에서 0과 1이 전환되므로, 두 개의 그룹이 있으면 하나의 뒤집기로 해결할 수 있다.
        // 예를 들어, "0001100"을 보면, "000", "11", "00" 총 3개의 그룹이 생기는데, 이를 완전히 뒤집기 위해선 2번의 뒤집기가 필요하다. 따라서 그룹 수를 2로 나누어 최소 뒤집기 횟수를 구한다.
        bufferedWriter.write(String.valueOf(minReverseBinaryString / 2));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int reverseBinary(String binaryString) {
        int count = 0;                                      // 연속된 0과 1의 그룹 수를 세기 위한 변수이다.
        char previousChar = binaryString.charAt(0);         // 현재 문자를 비교하는 기준이 된다.

        for (char c : binaryString.toCharArray()) {
            // 현재 문자(c)가 이전 문자(previousChar)와 다르면, 아래와 같이 수행한다.
            if (c != previousChar) {
                count++;                // 그룹의 전환의 발생했으므로 카운트 변수를 증가시킨다.
                previousChar = c;       // 현재 문자를 previousChar로 업데이트하여 다음 비교를 준비한다.
            }
        }

        return count + 1;               // 문자열에서 전환된 그룹 수를 반환한다. 첫 번째 그룹을 카운트하기 위해 1을 더해서 반환한다.
    }

    private static int reverseBinaryInList(String binaryString) {
        String[] zero = binaryString.split("0");
        String[] one = binaryString.split("1");

        List<String> zeroList = new ArrayList<>();
        List<String> oneList = new ArrayList<>();

        for (String z : zero) {
            if (!z.isEmpty()) zeroList.add(z);
        }

        for (String o : one) {
            if (!o.isEmpty()) oneList.add(o);
        }

        return Math.min(zeroList.size(), oneList.size());
    }

    private static int reverseBinaryInListOptimized(String binaryString) {
        int zeroGroupCount = 0;
        int oneGroupCount = 0;

        char previousChar = binaryString.charAt(0);
        if (previousChar == '0') zeroGroupCount++;
        else oneGroupCount++;

        for (int i = 1; i < binaryString.length(); i++) {
            char currentChar = binaryString.charAt(i);
            if (currentChar != previousChar) {
                if (currentChar == '0') zeroGroupCount++;
                else oneGroupCount++;
                previousChar = currentChar;
            }
        }

        return Math.min(zeroGroupCount, oneGroupCount);
    }
}
