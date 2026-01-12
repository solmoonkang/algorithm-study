package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 전화번호목록 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        String[] phoneNumbers = new String[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) phoneNumbers[i] = stringTokenizer.nextToken();

        boolean isPrefix = hasPrefixConflict(phoneNumbers);
        bufferedWriter.write(String.valueOf(isPrefix));
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 전화번호들을 정렬하면, 접두어 관계에 있는 번호들은 인접하게 정렬된다.
     * 인접한 번호끼리만 startsWith로 비교하면 충분하다.
     *  - 정렬하는데 O(N logN)을, 인접 쌍 비교하는 데 O(N * K)가 걸려 시간 복잡도는 O(N logN)을 가진다.
     */
    private static boolean hasPrefixConflict(String[] phoneNumbers) {
        Arrays.sort(phoneNumbers);

        for (int i = 0; i < phoneNumbers.length - 1; i++) {
            if (phoneNumbers[i + 1].startsWith(phoneNumbers[i])) return false;
        }

        return true;
    }

    /**
     * 모든 전화번호를 Hash에 저장한다.
     * 각 번호에 대해, 앞에서부터 한 글자씩 잘라가며 접두어를 만들어 본다.
     * 그 접두어가 이미 존재한다면 접두어 충돌이 발생해 fasle를 반환한다.
     *  - 번호 삽입하는 데 O(N), 접두어 검사에 O(N * K)으로 시간 복잡도는 O(N * K)를 가진다.
     */
    private static boolean hasPrefixConflictWithHash(String[] phoneNumbers) {
        Set<String> phoneNumberSet = new HashSet<>(Arrays.asList(phoneNumbers));

        for (String phoneNumber : phoneNumbers) {
            StringBuilder prefixBuilder = new StringBuilder();

            for (int i = 0; i < phoneNumber.length() - 1; i++) {
                prefixBuilder.append(phoneNumber.charAt(i));

                if (phoneNumberSet.contains(prefixBuilder.toString())) return false;
            }
        }

        return true;
    }

    /**
     * Trie는 문자열의 접두어를 트리 구조로 저장하는 자료구조이다.
     * 한 번호를 추가하다가 이미 다른 번호가 그 지점까지 들어와 있는 경우 접두어 충돌이 발생한다.
     * 또는 번호 추가 후 자식 노드가 존재한다면 현재 번호가 다른 번호의 접두어이다.
     *  - 시간복잡도는 Hash 방식과 동일하다.
     *  - 접두어 충돌을 탐지하는 타이밍이 훨씬 빨라 불필요한 접두어 전체 탐색 없이 처리가 가능하여 더 효율적이다.
     *  - 문자열 자체를 계층적으로 저장하므로, 접두어 충돌 여부를 직관적으로 판단 가능하다.
     */
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private static boolean hasPrefixConflictWithTrie(String[] phoneNumbers) {
        TrieNode rootNode = new TrieNode();

        for (String number : phoneNumbers) {
            TrieNode currentNode = rootNode;

            for (int i = 0; i < number.length(); i++) {
                char currentNumber = number.charAt(i);

                if (currentNode.isEndOfWord) return false;

                currentNode.children.putIfAbsent(currentNumber, new TrieNode());
                currentNode = currentNode.children.get(currentNumber);
            }

            if (!currentNode.children.isEmpty()) return false;
            currentNode.isEndOfWord = true;
        }

        return true;
    }
}
