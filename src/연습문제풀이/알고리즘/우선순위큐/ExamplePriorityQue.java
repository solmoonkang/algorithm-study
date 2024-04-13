package 연습문제풀이.알고리즘.우선순위큐;

import java.util.*;

public class ExamplePriorityQue {

    public static void main(String[] args) {

        /**
         * Priority Queue 선언
         */

        // Integer 타입으로 우선순위 큐를 선언( 낮은 숫자 순으로 우선순위를 결정 )
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();

        // Integer 타입으로 우선순위 큐를 선언( 높은 숫자 순으로 우선순위를 결정 )
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());



        /** ============================================================================== */

        /**
         * Priority Queue 값 추가
         *
         * 1, 15, 8, 21, 25, 18, 10 값 추가
         */

        // add( ) method : Collection 클래스에서 가져오는 메서드
        priorityQueue1.add(1);

        priorityQueue1.add(15);

        // offer( ) method : Queue 클래스에서 가져오는 메서드
        priorityQueue1.offer(10);

        priorityQueue1.add(21);

        priorityQueue1.add(25);

        priorityQueue1.offer(18);

        // 우선순위 큐의 동작 과정 :
        // 1. 우선순위 큐에 숫자 8을 추가한다 -> 숫자 8을 부모(10)와 비교해서 부모보다 작은 값일 경우 스왑한다 -> 10과 8의 위치가 변경된다
        // 2. 숫자 8을 다시 부모값과 비교한다 -> 하지만 자식값(8)이 부모값(1) 보다 더 크므로 스왑하지 않는다
        priorityQueue1.add(8);

        // 결과값을 보면, 입력한 순서가 아닌, 우선순위 큐만의 정렬 방식으로 정렬이 된다
        System.out.println("add( ) : " + priorityQueue1);



        /** ============================================================================== */

        /**
         * Priority Queue 값 삭제
         */

        // poll( ) method : 우선순위가 가장 높은 값을 제거한다
        // Result : [1, 15, 8, 21, 25, 18, 10], 1이 제거된다
        priorityQueue1.poll();

        System.out.println("poll( ) : " + priorityQueue1);

        // remove( ) method : 우선순위가 가장 높은 값을 제거한다
        // Result : [15, 8, 21, 25, 18, 10], 8이 제거된다
        priorityQueue1.remove();

        // remove(int index) method : index 순위에 해당하는 값을 제거한다
        // Result : [15, 21, 25, 18, 10], 21이 제거된다
        priorityQueue1.remove(1);

        System.out.println("remove( ) : " + priorityQueue1);

        // clear( ) method : 우선순위 큐의 모든 값을 삭제한다
        // Result : []
        priorityQueue1.clear();

        // 우선순위 큐 제거 과정 :
        // 결과값을 통해서 볼 수 있듯이 첫 번째 우선순위를 제거할 경우, 하나씩 밀리는 것이 아닌, 우선순위를 재정렬한다
        // 1. 루트 노드인 (1)과 마지막 노드인 (10)이 스왑된다
        // 2. 루트 노드인 (1)을 제거하고, 부모노드(10)과 자식노드(15, 8)을 비교하여 더 작은 값이 부모노드로 올라온다

        System.out.println("clear( ) : " + priorityQueue1);



        /** ============================================================================== */

        /**
         * Priority Queue 크기
         */

        priorityQueue1.add(1);

        priorityQueue1.add(15);

        priorityQueue1.offer(10);

        priorityQueue1.add(21);

        priorityQueue1.add(25);

        priorityQueue1.offer(18);

        priorityQueue1.add(8);

        System.out.println("size( ) : " + priorityQueue1.size());



        /** ============================================================================== */

        /**
         * Priority Queue 값 출력
         */

        // peek( ) method : 우선순위가 가장 높은 값을 출력한다
        System.out.println("peek( ) : " + priorityQueue1.peek());

        // 전체 Queue 의 값을 출력하려면, Iterator method 를 사용하여 출력한다
        Iterator iterator = priorityQueue1.iterator();

        while (iterator.hasNext()) {

            System.out.println("iterator : " + iterator.next() + "");
        }



        /** ============================================================================== */

        /**
         * Priority Queue 일차원 배열 추가
         */

        PriorityQueue<int[]> priorityQueue3 = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        priorityQueue3.add(new int[]{2, 3});
        priorityQueue3.add(new int[]{1, 1});
        priorityQueue3.offer(new int[]{3, 4});

        // 우선순위 큐로 1차원 배열을 출력하기 위해선 Iterator 혹은 반복문을 통해 출력해야하며, Arrays.toString( ) method 를 사용한다
        while (!priorityQueue3.isEmpty()) {

            int[] answer1 = priorityQueue3.poll();

            System.out.println("add( ) int[] : " + Arrays.toString(answer1));
        }



        /** ============================================================================== */

        /**
         * Priority Queue 이차원 배열 추가
         */

        PriorityQueue<int[][]> priorityQueue4 = new PriorityQueue<>(Comparator.comparingInt(o -> o[0][0]));

        priorityQueue4.add(new int[][]{{2, 3}, {4, 5}});
        priorityQueue4.add(new int[][]{{1, 1}, {3, 1}});
        priorityQueue4.add(new int[][]{{3, 4}, {2, 1}});

        // 우선순위 큐로 2차원 배열을 출력하기 위해선 1차원 배열과 마찬가지로 출력해야하며, Arrays.deepToString( ) method 를 사용한다
        while (!priorityQueue4.isEmpty()) {

            int[][] answer2 = priorityQueue4.poll();

            System.out.println("add( ) int[][] : " + Arrays.deepToString(answer2));
        }
    }
}
