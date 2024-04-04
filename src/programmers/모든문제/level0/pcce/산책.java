package programmers.모든문제.level0.pcce;

import java.util.Arrays;

public class 산책 {

    public int[] solution(String route) {
        int east = 0;
        int north = 0;
        int[] answer = new int [2];
        for(int i=0; i<route.length(); i++){
            switch(route.charAt(i)){
                case 'N':
                    north++;
                    break;
                case 'S':
                    north--;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    east--;
                    break;
            }
        }
        answer[0] = east;
        answer[1] = north;
        return answer;
    }

    public static void main(String[] args) {
        산책 walk = new 산책();

        System.out.println("walk = " + Arrays.toString(walk.solution("NSSNEWWN")));
        System.out.println("walk = " + Arrays.toString(walk.solution("EESEEWNWSNWWNS")));
    }
}
