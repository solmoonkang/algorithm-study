package programmers.foundation.level2;

public class 올바른괄호 {

    boolean solution(String s) {
        boolean answer = true;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                break;
            }
        }

        if (count == 0) {
            answer = true;
        }
        else {
            answer = false;
        }

        System.out.println("answer :" + answer);

        return answer;
    }

    public static void main(String[] args) {

        올바른괄호 solution = new 올바른괄호();
        solution.solution("())");
    }
}

//    Stack을 사용한 경우
//    boolean solution(String s) {
//        boolean answer = true;
//
//        Stack<Character> stack = new Stack<Character>();
//
//        if (s.charAt(0) == ')')
//            return false;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (!stack.empty() && s.charAt(i) == ')') {
//                stack.pop();
//            }
//            else {
//                stack.push(s.charAt(i));
//            }
//        }
//        answer = (stack.isEmpty()) ? true : false;
//        System.out.println("answer :" + answer);
//
//        return answer;
//    }