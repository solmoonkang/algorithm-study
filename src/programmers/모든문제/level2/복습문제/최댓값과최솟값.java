package programmers.모든문제.level2.복습문제;

public class 최댓값과최솟값 {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] splitString = s.split(" ");

        long min = Long.parseLong(splitString[0]);
        long max = Long.parseLong(splitString[0]);
        for (String string : splitString) {
            if (min > Integer.parseInt(string)) min = Long.parseLong(string);
            else if (max < Integer.parseInt(string)) max = Long.parseLong(string);
        }

        return answer.append(min).append(" ").append(max).toString();
    }

    public static void main(String[] args) {
        최댓값과최솟값 problem = new 최댓값과최솟값();

        System.out.println("problem = " + problem.solution("1 2 3 4"));
        System.out.println("problem = " + problem.solution("-1 -2 -3 -4"));
        System.out.println("problem = " + problem.solution("-1 -1"));
    }
}
