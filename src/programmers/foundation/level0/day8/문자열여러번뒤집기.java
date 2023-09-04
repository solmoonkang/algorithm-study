package programmers.foundation.level0.day8;

public class 문자열여러번뒤집기 {

    public String solution(String my_string, int[][] queries) {

        StringBuilder stringBuilder = new StringBuilder(my_string);

        for (int i = 0; i < queries.length; i++) {

            String answer = stringBuilder.substring(queries[i][0], queries[i][1] + 1);

            StringBuilder builder = new StringBuilder(answer);

            builder.reverse();

            stringBuilder.replace(queries[i][0], queries[i][1] + 1, builder.toString());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        문자열여러번뒤집기 reverse = new 문자열여러번뒤집기();

        int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};

        System.out.println("Result : " + reverse.solution("rermgorpsam", queries));
    }
}
