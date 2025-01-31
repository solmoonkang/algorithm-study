package 모든문제.level1.복습문제;

public class 음양더하기 {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        음양더하기 problem = new 음양더하기();

        int[] absolutes1 = {4,7,12};
        boolean[] signs1 = {true,false,true};
        System.out.println("problem = " + problem.solution(absolutes1, signs1));

        int[] absolutes2 = {1,2,3};
        boolean[] signs2 = {false,false,true};
        System.out.println("problem = " + problem.solution(absolutes2, signs2));
    }
}
