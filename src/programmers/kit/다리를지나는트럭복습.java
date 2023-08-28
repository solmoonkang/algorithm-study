package programmers.kit;

import java.util.Deque;
import java.util.LinkedList;

public class 다리를지나는트럭복습 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<Integer> deque = new LinkedList<>();



        int answer = 0;

        return answer;
    }

    public static void main(String[] args) {

        다리를지나는트럭복습 review = new 다리를지나는트럭복습();

        int[] truck_weights1 = {7, 4, 5, 6};
        int[] truck_weights2 = {10};
        int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println("Result : " + review.solution(2, 10, truck_weights1));
        System.out.println("Result : " + review.solution(100, 100, truck_weights2));
        System.out.println("Result : " + review.solution(100, 100, truck_weights3));
    }
}
