package programmers.모든문제.level1.알고리즘고득점KIT;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른괄호 {

    boolean solution(String s) {
        Deque<Character> parentheses = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') parentheses.offerLast(s.charAt(i));
            else if (s.charAt(i) == ')') {
                if (parentheses.isEmpty()) return false;
                parentheses.pollFirst();
            }
        }

        return parentheses.isEmpty();
    }

    public static void main(String[] args) {
        올바른괄호 problem = new 올바른괄호();

        System.out.println("problem = " + problem.solution("()()"));
        System.out.println("problem = " + problem.solution("(())()"	));
        System.out.println("problem = " + problem.solution(")()("));
        System.out.println("problem = " + problem.solution("(()("));
    }
}
