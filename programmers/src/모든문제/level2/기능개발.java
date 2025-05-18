package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 기능개발 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] progresses = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) progresses[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] speeds = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) speeds[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] deploymentCountsGroup = countFeaturesPerRelease(progresses, speeds);
        for (int features : deploymentCountsGroup) bufferedWriter.write(features + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] countFeaturesPerRelease(int[] progresses, int[] speeds) {
        Deque<Integer> remainingDays = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainTask = 100 - progresses[i];
            // Math.ceil(...)은 올림 처리로 소수점이 있을 경우 무조건 다음 정수로 올림한다.
            int remainDay = (int) Math.ceil((double) remainTask / speeds[i]);
            remainingDays.offerLast(remainDay);
        }

        List<Integer> deploymentCounts = new ArrayList<>();
        int current = remainingDays.pollFirst();
        int count = 1;

        while (!remainingDays.isEmpty()) {
            if (remainingDays.peekFirst() <= current) {
                count++;
                remainingDays.pollFirst();
            } else {
                deploymentCounts.add(count);
                current = remainingDays.pollFirst();
                count = 1;
            }
        }

        // while문이 끝나는 시점에는 마지막 배포 묶음을 아직 리스트에 추가하지 않았기 때문에, 마지막 배포 그룹을 한 번 더 넣어줘야 한다.
        deploymentCounts.add(count);

        return deploymentCounts.stream().mapToInt(i -> i).toArray();
    }
}
