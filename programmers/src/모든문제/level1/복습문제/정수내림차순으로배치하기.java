package 모든문제.level1.복습문제;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {

    public long solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            builder.append(chars[i]);
        }

        return (long) Long.parseLong(builder.reverse().toString());
    }

    public static void main(String[] args) {
        정수내림차순으로배치하기 problem = new 정수내림차순으로배치하기();

        System.out.println("problem = " + problem.solution(118372));
    }
}
