package 입문문제.day13;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 컨트롤제트 {

    /**
     * [ 문제 설명 ]
     * 숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다.
     * 문자열에 있는 숫자를 차례대로 더하려고 합니다. 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다.
     * 숫자와 "Z"로 이루어진 문자열 s가 주어질 때, 머쓱이가 구한 값을 반환하라.
     */

    /**
     * [ 제한 조건 ]
     * s는 숫자, "Z", 공백으로 이루어져 있습니다.
     * s에 있는 숫자와 "Z"는 서로 공백으로 구분됩니다.
     * 연속된 공백은 주어지지 않습니다.
     * 0을 제외하고는 0으로 시작하는 숫자는 없습니다.
     * s는 "Z"로 시작하지 않습니다.
     * s의 시작과 끝에는 공백이 없습니다.
     * "Z"가 연속해서 나오는 경우는 없습니다.
     */
    public int solution(String s) {
        // TODO: lastNum 부분에 대한 이해가 부족하다.
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("Z")) {
                int lastNum = list.remove(list.size() - 1);
                answer -= lastNum;
            } else {
                int num = Integer.parseInt(str[i]);
                list.add(num);
                answer += num;
            }
        }
        return answer;
    }

    public int solutionDeque(String s) {
        int answer = 0;
        Deque<Integer> deque = new LinkedList<>();
        String[] str = s.split(" ");

        for (String element : str) {
            if (element.equals("Z")) {
                if (!deque.isEmpty()) {
                    answer -= deque.pop();
                }
            } else {
                int num = Integer.parseInt(element);
                deque.push(num);
                answer += num;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        컨트롤제트 controlZet = new 컨트롤제트();
        System.out.println("Result: " + controlZet.solution("1 2 Z 3"));
        System.out.println("Result: " + controlZet.solution("10 20 30 40"));
        System.out.println("Result: " + controlZet.solution("10 Z 20 Z 1"));
        System.out.println("Result: " + controlZet.solution("10 Z 20 Z"));
        System.out.println("Result: " + controlZet.solution("-1 -2 -3 Z"));

        System.out.println("Result: " + controlZet.solutionDeque("1 2 Z 3"));
        System.out.println("Result: " + controlZet.solutionDeque("10 20 30 40"));
        System.out.println("Result: " + controlZet.solutionDeque("10 Z 20 Z 1"));
        System.out.println("Result: " + controlZet.solutionDeque("10 Z 20 Z"));
        System.out.println("Result: " + controlZet.solutionDeque("-1 -2 -3 Z"));
    }
}
