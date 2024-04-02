package programmers.알고리즘고득점KIT.greedy;

import java.util.Deque;
import java.util.LinkedList;

public class 큰수만들기 {

    /** 참고 - 거스름돈
     *  1. 선택 절차 : 거스름돈 문제에서 가장 가치가 큰 동전부터 선택을 합니다.
     *  2. 적절성 검사: 만약 선택된 동전의 가치가 거스름돈보다 크다면 다음으로 작은 동전을 선택합니다.
     *  3. 해답 검사 : 합이 일치하면 거스름돈 문제가 해결되었습니다.
     */

    /** Tip
     *  String 문자열은 불변이므로 문자열을 이어붙이는 경우, StringBuilder 를 통해 append 하는 것이 더 효율적이다
     */


    public String solution(String number, int k) {

        // 문자열은 사실상 문자의 배열이기 때문에, 문자열을 구성하는 각각의 문제를 처리하려면, 'char' 타입을 사용하는 것이 효율적이다
        // 또한, 입력받은 숫자를 한 자리씩 처리하기 위해 설정한다
        // 마지막으로, StringBuilder 의 append 는 char 와 String 모두를 인수로 받을 수 있으므로 char 를 사용했다
        Deque<Character> deque = new LinkedList<>();

        // 1. 선택 절차 : 현 상태에서 최적의 선택을 한다
        // 가장 왼쪽부터 시작해서 현재 숫자보다 다음 숫자가 더 크다면, 현재 숫자를 제거한다
        for (int i = 0; i < number.length(); i++) {

            // 문자열에서 i번째 위치에 있는 문자를 가져와서 c라는 변수에 저장하는 것을 의미한다
            char c = number.charAt(i);

            // 2. 적절성 검사 : 선택한 항목이 문제의 조건을 만족하는지 확인한다
            // 만약, k번 모두 제거하지 못했고, 아직 제거할 숫자가 남아있다면, 남은 숫자 중 가장 작은 숫자를 제거한다

            // !deque.isEmpty() : 덱이 비어있지 않은지 확인한다
            // deque.peekLast() < c : 덱의 마지막 요소가 현재 문자보다 작은지 확인한다
            // k > 0 : 아직 제거할 수 있는 횟수가 남아 있는지 확인한다
            while (!deque.isEmpty() && deque.peekLast() < c && k > 0) {     // && : AND 연산, || : OR 연산
                deque.pollLast();   // 덱의 마지막 요소를 제거한다
                k--;                // 제거 가능한 횟수(k)에서 1을 차감한다
            }

            // 현재 문자를 덱에 추가한다
            deque.offer(c);
        }

        StringBuilder stringBuilder = new StringBuilder();

        // 3. 해답 검사 : 최종 선택이 문제의 조건을 만족하는지 확인한다
        // 입력된 숫자에서 k개 이상의 숫자를 제거하지 못하는 경우 또한 조건에 추가해야 한다, 따라서 전체 자릿수 중 필요한 만큼만 반환해야 한다
        while (!deque.isEmpty() && stringBuilder.length() < (number.length() - k)) {
            // 덱의 첫 번째 요소를 꺼내와서 stringBuilder 객체에 추가한다
            stringBuilder.append(deque.pollFirst());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        큰수만들기 bigNumber = new 큰수만들기();

        System.out.println("Result : " + bigNumber.solution("1924", 2));
        System.out.println("Result : " + bigNumber.solution("1231234", 3));
        System.out.println("Result : " + bigNumber.solution("4177252841", 4));
    }
}
