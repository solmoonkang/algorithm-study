package 모든문제.level1.복습문제;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억점수 {

    // TODO: 다시 한 번 더 풀어보자.
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> yearningMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int photoYearning = 0;
            for (String person : photo[i]) {
                photoYearning += yearningMap.getOrDefault(person, 0);
            }

            answer[i] = photoYearning;
        }

        return answer;
    }

    public static void main(String[] args) {
        추억점수 problem = new 추억점수();

        String[] name1 = {"may", "kein", "kain", "radi"};
        int[] yearning1 = {5, 10, 1, 3};
        String[][] photo1 = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        System.out.println("problem = " + Arrays.toString(problem.solution(name1, yearning1, photo1)));

        String[] name2 = {"kali", "mari", "don"};
        int[] yearning2 = {11, 1, 55};
        String[][] photo2 = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};
        System.out.println("problem = " + Arrays.toString(problem.solution(name2, yearning2, photo2)));

        String[] name3 = {"may", "kein", "kain", "radi"};
        int[] yearning3 = {5, 10, 1, 3};
        String[][] photo3 = {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};
        System.out.println("problem = " + Arrays.toString(problem.solution(name3, yearning3, photo3)));
    }
}
