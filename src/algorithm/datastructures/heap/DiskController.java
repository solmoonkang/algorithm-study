package algorithm.datastructures.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

    public int solution(int[][] jobs) {

        int answer = 0;

        PriorityQueue<int[][]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0][0]));

        priorityQueue.add(jobs);

        System.out.println(priorityQueue);

        return answer;
    }

    public static void main(String[] args) {

        DiskController diskController = new DiskController();

        int[][] jobs = {{0,3}, {1,9}, {2,6}};

        System.out.println("Result : " + diskController.solution(jobs));
    }
}
