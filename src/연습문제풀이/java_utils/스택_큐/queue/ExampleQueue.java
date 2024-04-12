package 연습문제풀이.java_utils.스택_큐.queue;

import java.util.*;

public class ExampleQueue {

    public int[] solution_hate_same_number(int[] arr) {

        // 덱을 큐로 사용 : FIFO ( offerLast, pollFirst )
        Deque<Integer> deque = new LinkedList<>();

        // 이전에 확인한 숫자를 저장
        int value = -1;


        for (int i = 0; i < arr.length; i++) {

            // 만약, 현재 배열 arr 원소와 value 변수의 값과 같지 않을 경우
            if (arr[i] != value) {

                // 배열 arr 원소들을 덱에 삽입
                deque.offerLast(arr[i]);

                // 이전에 확인한 숫자를 현재 숫자로 업데이트
                value = arr[i];
            }
        }

        int[] answer = new int[deque.size()];

        for (int i = 0; i < answer.length; i++) {

            answer[i] = deque.pollFirst();
        }

        return answer;
    }

    public int[] solution_develop(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();

        // 덱을 큐로 사용 : FIFO ( offerLast, pollFirst )
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {

            // (100 - progresses[i])는 개발 완료까지 남은 작업의 백분율을 계산 ( 100% 에서 현재 진행률 progresses[i]을 뺀 값 )
            // 남은 작업 백분율을 개발 속도 ( speeds[i] )로 나눈 나머지를 계산
            // 만약, 나머지가 0인 경우 ( 개발 완료 시간은 정확하게 나누어 떨어진다 ),
            if ((100 - progresses[i]) % speeds[i] == 0) {

                // 완료 시간을 정수 형태로 덱에 추가
                deque.offerLast((100 - progresses[i]) / speeds[i]);
            }

            // 남은 작업률과 개발 속도가 정확하게 나누어 떨어지지 않는 경우,
            else {

                // 남은 작업 백분율을 개발 속도로 나눈 몫을 구하고, 몫에 1을 더해 소수점을 올림하고 덱에 추가
                deque.offerLast((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        // 첫 번째 기능 완료 일정(배포 날짜)을 덱에서 가져와 변수 x에 저장
        int x = deque.pollFirst();
        // 동시에 배포되는 기능 개수를 셀 변수 count 를 초기화하여 1로 설정
        int count = 1;

        // 덱이 비어있지 않을 때까지 다음 작업을 반복
        while (!deque.isEmpty()) {

            // 만약, 덱의 첫 번째 원소와 x를 비교하여 같거나 작은 경우 ( 다음 기능 배포 일정이 같은 날짜이거나 더 빠른 경우 ),
            // 해당 기능은 같은 날짜에 배포할 수 있다
            if (x >= deque.peekFirst()) {

                // count 변수를 1 증가시키고
                count++;

                // 덱에서 해당 기능을 제거
                deque.pollFirst();
            }

            // 만약, 덱의 첫 번째 원소가 x보다 큰 경우 ( 다음 기능 배포 일정이 더 늦은 경우 ),
            else {

                // count 에 저장된 현재까지의 동시 배포 기능 개수를 list 에 추가
                list.add(count);

                // count 변수를 1로 초기화
                count = 1;

                // 다음 기능의 배포 일정을 가져와서 x 변수에 저장한 후, 덱에서 해당 기능을 제거
                x = deque.pollFirst();
            }
        }

        // 배포일에 완료된 기능들의 개수 ( count )도 list 에 추가
        list.add(count);

        int[] answer = list.stream().mapToInt(o -> o).toArray();

        return answer;
    }

    boolean solution_parentheses(String s) {

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                deque.offerLast('(');
            }

            else {

                if (deque.isEmpty()) {

                    return false;
                }

                deque.pollFirst();
            }
        }

        return deque.isEmpty();
    }

    public int solution_process(int[] priorities, int location) {

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {

            deque.offerLast(i);
        }

        int value = 0;

        while (!deque.isEmpty()) {

            int current = deque.pollFirst();
            boolean higherPriority = false;

            for (int index : deque) {

                if (priorities[index] > priorities[current]) {

                    higherPriority = true;

                    break;
                }
            }

            if (higherPriority) {

                deque.offerLast(current);
            }

            else {

                value++;

                if (current == location) {

                    break;
                }
            }
        }

        return value;
    }

    public static void main(String[] args) {

        ExampleQueue queue = new ExampleQueue();

        int[] hate1 = {1,1,3,3,0,1,1};
        int[] hate2 = {4,4,4,3,3};

        System.out.println("I Hate Same Number : " + Arrays.toString(queue.solution_hate_same_number(hate1)));
        System.out.println("I Hate Same Number : " + Arrays.toString(queue.solution_hate_same_number(hate2)));
        System.out.println("==========================");

        int[] progress1 = {93,30,55};
        int[] progress2 = {95,90,99,99,80,99};
        int[] speeds1 = {1,30,5};
        int[] speeds2 = {1,1,1,1,1,1};

        System.out.println("Function Develop : " + Arrays.toString(queue.solution_develop(progress1, speeds1)));
        System.out.println("Function Develop : " + Arrays.toString(queue.solution_develop(progress2, speeds2)));
        System.out.println("==========================");

        System.out.println("Correct Parentheses : " + queue.solution_parentheses("()()"));
        System.out.println("Correct Parentheses : " + queue.solution_parentheses("(())()"));
        System.out.println("Correct Parentheses : " + queue.solution_parentheses(")()("));
        System.out.println("Correct Parentheses : " + queue.solution_parentheses("(()("));
        System.out.println("==========================");

        int[] priorities1 = {2,1,3,2};
        int[] priorities2 = {1,1,9,1,1,1};

        System.out.println("Process : " + queue.solution_process(priorities1, 2));
        System.out.println("Process : " + queue.solution_process(priorities2, 0));
        System.out.println("==========================");
    }
}
