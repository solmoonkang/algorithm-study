package baekjoon.알고리즘분류.그리디알고리즘.연습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 활동선택 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Action> actionList = new ArrayList<>();

        actionList.add(new Action("A", 7, 8));
        actionList.add(new Action("B", 5, 7));
        actionList.add(new Action("C", 3, 6));
        actionList.add(new Action("D", 1, 2));
        actionList.add(new Action("E", 6, 9));
        actionList.add(new Action("F", 10, 11));

        Collections.sort(actionList);

        List<Action> greedyActionList = greedyAlgorithm(actionList);
        for (Action activity : greedyActionList) {
            bufferedWriter.write(activity.name + ", ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static List<Action> greedyAlgorithm(List<Action> actionList) {
        int time = 0;

        List<Action> greedyActionList = new ArrayList<>();

        for (Action activity : actionList) {
            if (time <= activity.startTime) {
                time = activity.endTime;
                greedyActionList.add(activity);
            }
        }

        return greedyActionList;
    }

    public static class Action implements Comparable<Action> {
        String name;
        int startTime;
        int endTime;

        private Action(String name, int startTime, int endTime) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Action o) {
            return this.endTime - o.endTime;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
