package algorithm.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ExampleDeque {

    public static void main(String[] args) {

        /** ============================================================================== */

        /**
         * Deque 생성
         */

        Deque<String> arrayDeque = new ArrayDeque<>();

        Deque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();

        Deque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

        Deque<String> linkedListDeque = new LinkedList<>();

        /** ============================================================================== */

        /**
         * Deque 값 추가
         */

        Deque<Integer> deque = new LinkedList<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);




        /** ============================================================================== */

        /**
         * Deque 값 삭제
         */







        /** ============================================================================== */

        /**
         * Deque 값 확인
         */
    }
}
