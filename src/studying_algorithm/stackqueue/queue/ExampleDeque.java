package studying_algorithm.stackqueue.queue;

import java.util.*;

public class ExampleDeque {

    public int[] iDonNotWantTheSameNumber(int[] arr) {

        // 배열 arr 각 원소는 숫자 0부터 9까지 이루어져 있다
        // 이떄, 배열 arr 에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거한다
        // ( 단, 제거된 후 남은 수들을 반환할 때는 배열 arr 의 원소들의 순서를 유지해야 한다 )

        // EX) arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 반환
        // EX) arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 반환

        Deque<Integer> deque = new LinkedList<>();

        int value = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != value) {

                deque.offerLast(arr[i]);

                value = arr[i];
            }
        }

        int[] answer = new int[deque.size()];

        for (int i = 0; i < answer.length; i++) {

            answer[i] = deque.pollFirst();
        }

        return answer;
    }

    public int[] functionalDevelopment(int[] progresses, int[] speeds) {

        // 각 기능은 진도가 100% 일 때, 서비스에 반영할 수 있다
        // 또한, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수도 있고,
        // 이때, 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포된다

        // 각 배포마다 몇 개의 기능이 배포되는지를 반환하라

        // 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포되기 때문에, 선입선출로 인해 Queue 로 구현
        Deque<Integer> deque = new LinkedList<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {

            if ((100 - progresses[i]) % speeds[i] == 0 ) {

                deque.offerLast((100 - progresses[i]) / speeds[i]);
            } else {

                deque.offerLast((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        // 첫 번째 완료 예상 시간을 저장하는 변수
        int firstSuccessExpectTime = deque.pollFirst();

        // 몇 개의 기능이 배포되는지 저장하는 변수
        int count = 1;

        while (!deque.isEmpty()) {

            if (firstSuccessExpectTime >= deque.peekFirst()) {

                count++;

                deque.pollFirst();
            } else {

                list.add(count);

                count = 1;

                firstSuccessExpectTime = deque.pollFirst();
            }
        }

        list.add(count);

        // count 변수의 값들을 answer 배열에 저장
        int[] answer = list.stream().mapToInt(o -> o).toArray();

        // answer 배열을 반환
        return answer;
    }

    boolean correctParentheses(String s) {

        // 괄호가 바르게 짝지어진 것은 '(' 문자로 열렸으면, 반드시 ')' 문자로 닫혀야 한다
        // '(' 또는 ')' 로만 이루어진 문자열 s가 올바른 괄호이면 true, 올바르지 않은 괄호이면 false 를 반환하라

        Deque<String> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                deque.offerLast("(");
            } else if (s.charAt(i) == ')') {

                if (deque.isEmpty()) {

                    return false;
                }

                deque.pollLast();
            }
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {

        ExampleDeque exampleDeque = new ExampleDeque();

        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        System.out.println("I don't want the same number");
        System.out.println("Result : " + Arrays.toString(exampleDeque.iDonNotWantTheSameNumber(arr)));

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println("Functional Development");
        System.out.println("Result : " + Arrays.toString(exampleDeque.functionalDevelopment(progresses, speeds)));

        System.out.println("Correct Parentheses");
        System.out.println("Result : " + exampleDeque.correctParentheses("()()"));
        System.out.println("Result : " + exampleDeque.correctParentheses("(())()"));
        System.out.println("Result : " + exampleDeque.correctParentheses(")()("));
        System.out.println("Result : " + exampleDeque.correctParentheses("(()("));
    }
}
