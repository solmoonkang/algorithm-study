package 모든문제.level2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class 구명보트 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] people = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) people[i] = Integer.parseInt(stringTokenizer.nextToken());

        int limit = Integer.parseInt(bufferedReader.readLine());

        int lifeBoats = getMinLifeBoats(people, limit);
        bufferedWriter.write(String.valueOf(lifeBoats));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinLifeBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0, right = people.length - 1;
        int count = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) left++;
            right--;
            count++;
        }

        return count;
    }

    /**
     * 개선 포인트
     * - 불필요한 boxing/unboxing으로 인해 성능적으로 손해가 된다.
     * - Deque는 객체 기반 자료구조이기 때문에 peek 혹은 poll할 때마다 내부 연결 구조에 접근이 필요하다.
     * - pollFirst() 하면 실제로 내부 배열 혹은 연결 리스트를 재구성하거나 인덱스 이동이 필요하다.
     */
    private static int getMinLifeBoatsWithDeque(int[] people, int limit) {
        Arrays.sort(people);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int person : people) deque.offerLast(person);

        int count = 0;

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();

            if (!deque.isEmpty() && current + deque.peekFirst() <= limit) {
                deque.pollFirst();
            }
            count++;

        }

        return count;
    }


    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }

        return people.length - i;
    }
}
