package 모든문제.level1.복습문제;

public class 서울에서김서방찾기 {

    public String solution(String[] seoul) {
        int location = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) location = i;
        }

        return "김서방은 " + location + "에 있다";
    }

    public static void main(String[] args) {
        서울에서김서방찾기 problem = new 서울에서김서방찾기();

        String[] seoul = {"Jane", "Kim"};
        System.out.println("problem = " + problem.solution(seoul));
    }
}
