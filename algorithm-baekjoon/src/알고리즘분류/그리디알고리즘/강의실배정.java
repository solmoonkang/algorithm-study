package 알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] classSchedule = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            classSchedule[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            classSchedule[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int classroomsNumber = getNumberOfClassrooms(classSchedule);
        bufferedWriter.write(String.valueOf(classroomsNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getNumberOfClassrooms(int[][] classSchedule) {
        Arrays.sort(classSchedule, Comparator.comparingInt(a -> a[0]));

        // 종료 시간을 관리하는 우선순위 큐
        PriorityQueue<Integer> classEndTimes = new PriorityQueue<>();

        for (int[] schedule : classSchedule) {
            // 종료 시간이 현재 수업 시작 시간보다 작거나 같으면 강의실 재사용
            if (!classEndTimes.isEmpty() && classEndTimes.peek() <= schedule[0]) classEndTimes.poll();
            // 현재 수업의 종료 시간을 큐에 추가
            classEndTimes.offer(schedule[1]);
        }

        // 남아 있는 종료 시간의 개수가 필요한 강의실 수
        return classEndTimes.size();
    }
}
