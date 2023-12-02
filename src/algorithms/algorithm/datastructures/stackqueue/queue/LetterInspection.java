package algorithms.algorithm.datastructures.stackqueue.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LetterInspection {

    // 주어진 문자열이 회문인지 확인하는 문제로, 앞에서 읽으나 뒤에서 읽으나 동일한 문자열을 의미한다
    // 문자열 s 는 소문자로만 이루어져 있으며, 문자열이 회문이면 true, 그렇지 않으면 false 를 출력한다

    public boolean solution(String s) {

        Queue<Character> forward = new LinkedList<>();
        Queue<Character> backward = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            // 문자열을 정순으로 forward 큐에 삽입
            forward.offer(s.charAt(i));
            // 문자열을 역순으로 backward 큐에 삽입

            // i = 0 일 때, s.length() - 1 - i = 4, s.charAt(4) = 'e'
            // i = 1 일 때, s.length() - 1 - i = 3, s.charAt(4) = 'l'
            // i = 2 일 때, s.length() - 1 - i = 2, s.charAt(4) = 'p'
            // i = 3 일 때, s.length() - 1 - i = 1, s.charAt(4) = 'p'
            // i = 4 일 때, s.length() - 1 - i = 0, s.charAt(4) = 'a'
            backward.offer(s.charAt(s.length() - 1 - i));
        }

        // if 문이 아닌 while 문으로 처리한 이유 :
        // if 문은 단 하나의 원소에 대해서만 조건을 검사하는 반면, while 문의 경우, forward 큐의 모든 원소를 차례로 검사하고 처리한다
        // 즉, 모든 원소를 처리할 때까지 해당 코드 블록 내 명령을 계속 실행한다
        while(!forward.isEmpty()) {
            // forward 큐와 backward 큐의 원소가 서로 다르다면, false 를 반환
            if (!forward.poll().equals(backward.poll())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        LetterInspection letter = new LetterInspection();

        System.out.println("Result : " + letter.solution("level"));
        System.out.println("Result : " + letter.solution("queue"));
        System.out.println("Result : " + letter.solution("racecar"));
        System.out.println("Result : " + letter.solution("hello"));
    }
}
