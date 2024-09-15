package programmers.모든문제.level1.복습문제;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 가장가까운글자 {

    // TODO: 문제 풀이는 성공했으나, 시간복잡도가 O(n^2)가 나와서 효율성 테스트에서 실패했다.
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (lastSeen.containsKey(currentChar)) answer[i] = i - lastSeen.get(currentChar);
            lastSeen.put(currentChar, i);
        }

        return answer;
    }

    public static void main(String[] args) {
        가장가까운글자 problem = new 가장가까운글자();

        System.out.println("problem = " + Arrays.toString(problem.solution("banana")));
        System.out.println("problem = " + Arrays.toString(problem.solution("foobar")));
    }
}
