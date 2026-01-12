package 알고리즘분류.브루트포스알고리즘;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 덩치 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int X = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken());
            people.add(new Person(X, Y));
        }

        int[] bodyRanking = new int[N];

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    if ((people.get(i).weight < people.get(j).weight) && (people.get(i).height < people.get(j).height))
                        rank++;
                }
            }

            bodyRanking[i] = rank;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int rank : bodyRanking) {
            stringBuilder.append(rank).append(" ");
        }

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
