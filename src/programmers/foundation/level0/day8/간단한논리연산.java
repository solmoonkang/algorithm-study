package programmers.foundation.level0.day8;

public class 간단한논리연산 {

    /**
     *  논리연산
     *  AND ( ∧ )
     *  A, B 둘 다 true 일 경우, true
     *  그 외 나머지는 모두 false
     *
     *  OR ( ∨ )
     *  A, B 둘 중 하나가 true 일 경우, true
     *  그 외 나머지는 모두 false
     */

    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {

        boolean answer = true;

        return answer = (x1 || x2) && (x3 || x4);
    }

    public static void main(String[] args) {

        간단한논리연산 logic = new 간단한논리연산();

        System.out.println("Result1 : " + logic.solution(false, true, true, true));
        System.out.println("Result2 : " + logic.solution(true, false, false, false));
    }
}
