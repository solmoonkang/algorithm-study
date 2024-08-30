package programmers.모든문제.level1.복습문제;

public class 문자열내P와Y의개수 {

    boolean solution(String s) {
        int countP = 0;
        int countY = 0;

        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p') countP++;
            else if (c == 'y') countY++;
        }

        return countP == countY;
    }

    public static void main(String[] args) {
        문자열내P와Y의개수 problem = new 문자열내P와Y의개수();

        System.out.println("problem = " + problem.solution("pPoooyY"));
        System.out.println("problem = " + problem.solution("Pyy"));
    }
}
