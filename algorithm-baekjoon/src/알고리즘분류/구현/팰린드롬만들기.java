package 알고리즘분류.구현;

import java.io.*;

public class 팰린드롬만들기 {

    private static final String IS_IMPOSSIBLE = "I'm Sorry Hansoo";
    private static final int ALPHABET_RANGE = 256;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String englishName = bufferedReader.readLine();
        String palindromeName = generatePalindrome(englishName);
        bufferedWriter.write(palindromeName);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String generatePalindrome(String name) {
        /*
          ▶️ 문자 별 등장 횟수 세기
          - ALPHABET_RANGE는 보통 128(ASCII)나 256(Extended ASCII) 등 알파벳 코드 전체 범위 크기이다.
          - name.toCharArray()로 문자열을 문자 배열로 바꾸고, 각 문자 코드(alphabet)를 인덱스로 사용해 count[alphabet]를 1씩 증가시킨다.
          - 예를 들어, "AABBC"라면 count['A'] == 2, count['B'] == 2, count['C'] == 1
         */
        int[] count = new int[ALPHABET_RANGE];
        for (char alphabet : name.toCharArray()) count[alphabet]++;

        /*
          ▶️ 홀수 개수 문자가 몇 개인지 파악
          - 펠린드롬을 만들려면 짝수 길이 문자열은 모든 문자의 개수가 짝수여야 하고, 홀수 길이 문자열은 한 문자만 홀수여야 한다.
          - count[alphabet] % 2 == 1은 해당 문자가 홀수 개임을 뜻하므로, oddCount에 그 문자의 개수를 센 뒤, oddChar에 그 문자 코드를 저장해 둔다.
          - 만약 홀수 개인 문자가 두 개 이상이라면 펠린드롬 재배열이 불가능하므로 즉시 IS_IMPOSSIBLE를 반환한다.
         */
        int oddCount = 0;
        char oddChar = 0;

        for (int alphabet = 0; alphabet < ALPHABET_RANGE; alphabet++) {
            if (count[alphabet] % 2 == 1) {
                oddCount++;
                oddChar = (char) alphabet;
            }
        }

        if (oddCount > 1) return IS_IMPOSSIBLE;

        /*
          ▶️ 왼쪽 절반 문자열 만들기
          - 각 문자를 count[alphabet] / 2개만큼 절반으로 떼어내서, 그것들을 오름차순으로 차례차례 이어 붙인다.
          - 예를 들어, count['A'] == 3이면 3/2=1개만, count['B'] == 2면 2/2=1개만 붙여서 "AABBC" -> halfBuilder = "AB"로 만든다.
         */
        StringBuilder halfBuilder = new StringBuilder();
        for (int alphabet = 0; alphabet < ALPHABET_RANGE; alphabet++) {
            halfBuilder.append(String.valueOf((char) alphabet).repeat(Math.max(0, count[alphabet] / 2)));
        }

        /*
          ▶️ 가운데 문자와 오른쪽 절반 붙이기
          - center는 홀수 개 문자(oddChar)가 하나 있었다면, 그 문자를 딱 한 글자 가운데에 삽입한다. 홀수 문자가 없으면 빈 문자열을 삽입한다.
          - right는 halfBuilder를 뒤집어서 오른쪽 절반을 만든다.
          - 다시 halfBuilder.reverse()로 원래 순서(왼쪽 절반)로 되돌리고, append(center)로 가운데 문자, append(right)로 뒷부분(뒤집힌 절반)을 붙여 완성한다.
         */
        String center = (oddCount == 1) ? String.valueOf(oddChar) : "";
        String right = halfBuilder.reverse().toString();
        return halfBuilder.reverse().append(center).append(right).toString();
    }
}
