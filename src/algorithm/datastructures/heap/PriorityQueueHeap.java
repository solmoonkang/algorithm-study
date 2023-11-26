package algorithm.datastructures.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueHeap {

    public int moreSpicy(int[] scoville, int K) {

        // Leo 는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶어한다
        // 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해서는 스코빌 지수가 가장 낮은 두 개의 음식을 섞어서 만들어야 한다

        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + ( 두 번째로 맵지 않은 음식의 스코빌 지수 * 2 )
        // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복해서 섞고, 해당 음식들을 만들기 위해 섞어야 하는 최소 횟수를 반환하라
        // ( 단, 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우, -1을 반환하라 )

        // 최소 횟수를 반환하기 위해 최솟값 우선 순위로 우선순위 큐를 선언
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 해당 음식을 만들기 위해 섞어야 하는 최소 횟수를 저장
        int answer = 0;

        // 우선순위 큐에 스코빌 배열을 삽입
        for (int scov : scoville) {

            priorityQueue.add(scov);
        }

        // 우선순위 큐가 비어있지 않다면, 해당 반복문을 계속해서 실행한다
        // 즉, 우선순위 큐에 요소가 두 개 이상 있고, 가장 작은 스코빌 지수가 K보다 작은 경우에만 음식을 섞는다
        while (priorityQueue.size() > 1 && priorityQueue.peek() < K) {

            int leastSpicyFood = priorityQueue.poll();
            int secondLeastSpicyFood = priorityQueue.poll();

            int mixedFood = leastSpicyFood + (secondLeastSpicyFood * 2);

            priorityQueue.add(mixedFood);

            answer++;
        }

        if (priorityQueue.peek() < K) {

            return -1;
        } else {

            return answer;
        }
    }

    public int diskController(int[][] jobs) {

        // 하드디스크는 한 번에 하나의 작업만 수행할 수 있다
        // 각 작업의 요청부터 종료까지 걸린 시간의 평균은 A + B + C / 3( A, B, C : 3개 )

        // 2차원 배열 jobs = [ 작업이 요청되는 시점, 작업의 소요시간 ]
        // 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면, 평균이 얼마가 되는지 반환하라
        // ( 단, 소수점 이하의 수는 버린다 ) : Math.floor

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 작업 소요시간으로 오름차순 정렬

        int answer = 0;

        return answer;
    }

    //    Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
    //
    //    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 작업 소요시간으로 오름차순 정렬
    //
    //    int answer = 0;
    //    int count = 0; // 처리된 작업 수
    //    int time = 0; // 현재 시각
    //
    //    int i = 0;
    //
    //    while(count < jobs.length){
    //        while(i < jobs.length && jobs[i][0] <= time){
    //            priorityQueue.offer(jobs[i++]);
    //        }
    //
    //        if(priorityQueue.isEmpty()){
    //            time = jobs[i][0];
    //        }else{
    //            int[] job = priorityQueue.poll();
    //            answer += job[1] + time - job[0];
    //            time += job[1];
    //            count++;
    //        }
    //
    //    }
    //
    //   return (int)Math.floor(answer/jobs.length);

    public static void main(String[] args) {

        PriorityQueueHeap priorityQueueHeap = new PriorityQueueHeap();

        int[] scoville = {1, 2};

        System.out.println("More Spicy");
        System.out.println("Result : " + priorityQueueHeap.moreSpicy(scoville, 11));

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        System.out.println("Disk Controller");
        System.out.println("Result : " + priorityQueueHeap.diskController(jobs));
    }
}
