package programmers.coding_basic_training.level2;

import java.util.Deque;
import java.util.LinkedList;

public class 짝지어제거하기 {

    public int solution(String s) {

        // 짝지어 제거하기란, 알파벳 소문자로 이루어진 문자열을 가지고 시작한다 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾는다
        // 그 다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙인다 해당 과정을 반복해서 문자열을 모두 제거한다면, 짝지어 제거하기가 끝난다
        // 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성하고 성공적으로 수행하면 1을, 아니면 0을 반환하라


        // 그냥 스택을 이용해서 값을 하나씩 넣고 같은 값이 들어오면 poll 하면 된다

        Deque<String> deque = new LinkedList<>();

        for (char c : s.toCharArray()) {

            if (!deque.isEmpty() && deque.peekLast().equals(String.valueOf(c))) {

                deque.pollLast();

            } else {

                deque.offerLast(String.valueOf(c));

            }
        }

        return deque.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {

        짝지어제거하기 remove = new 짝지어제거하기();

        System.out.println("Result : " + remove.solution("baabaa"));
        System.out.println("Result : " + remove.solution("cdcd"));
    }
}
