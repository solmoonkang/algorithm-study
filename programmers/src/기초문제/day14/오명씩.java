package 기초문제.day14;

import java.util.ArrayList;
import java.util.Arrays;

public class 오명씩 {

    public String[] solution(String[] names) {

        // 최대 5명씩 탑승가능한 놀이기구를 타기 위해 줄을 서있는 사람들의 이름이 담긴 문자열 리스트 names 가 주어질 때,
        // 앞에서부터 5명씩 묶은 그룹의 가장 앞에 서있는 사람들의 이름을 담은 리스트를 return 하도록 solution 함수를 완성해주세요.
        // 마지막 그룹이 5명이 되지 않더라도 가장 앞에 있는 사람의 이름을 포함합니다.

        // 즉, names 배열의 원소들을 5개씩 묶어서 만들고, 해당 묶음의 가장 앞에 있는 이름들을 리스트를 반환하라

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < names.length; i+=5) {

            list.add(names[i]);
        }

        String[] answer = list.stream().toArray(String[]::new);

        return answer;
    }

    public static void main(String[] args) {

        오명씩 five = new 오명씩();

        String[] names = {"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"};

        System.out.println("Result : " + Arrays.toString(five.solution(names)));
    }
}
